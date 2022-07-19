package ru.geekbrains.com.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.com.dto.ProfileDto;
import ru.geekbrains.com.dto.ProfileGetAllDtoRequest;
import ru.geekbrains.com.dto.ProfileGetAllDtoResponse;
import ru.geekbrains.com.entity.Profile;
import ru.geekbrains.com.entity.ProfileStatus;
import ru.geekbrains.com.integration.IntegrationAuthService;
import ru.geekbrains.com.repositories.ProfileRepository;
import ru.geekbrains.com.repositories.specification.ProfileSpecification;
import ru.geekbrains.com.validators.FieldNameChecker;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Service
public class ProfileServiceImpl implements ProfileService{
    private final String CHANGE_STATUS_QUERY ="UPDATE Profile  set status=:status where id=:id";
    private final String GET_PROFILE ="SELECT new ru.geekbrains.com.dto.ProfileDto(p.id,p.firstname,p.surname,p.lastname) from Profile as p" +
            " where p.id=:id";
    private final ProfileRepository profileRepository;

    private final IntegrationAuthService authService;
    private final EntityManager entityManager;

    public ProfileServiceImpl(ProfileRepository profileRepository, IntegrationAuthService authService, EntityManager entityManager) {
        this.profileRepository = profileRepository;
        this.authService = authService;
        this.entityManager = entityManager;
    }

    @Override
    public Page<ProfileGetAllDtoResponse> getAllUsers(ProfileGetAllDtoRequest param) {
        if(param.getPage()==null){
            param.setPage(1);
        }
        /*ASC по возрастанию Desc убывание*/
        Sort.Direction direction =Sort.Direction.ASC;
        if (!param.getDirectSort()){
            direction = Sort.Direction.DESC;
        }
        Sort sort;
        String field = FieldNameChecker.checkFieldName(Profile.class,param.getSortField());
        if (field!=null){
            sort = Sort.by(direction,param.getSortField());
        }else {
            sort = Sort.by(direction,"id");
        }

        /*Добавляем спецификацию исходя из параметров запроса*/
        Specification<Profile> spec;
        /*Если строка запроа пуста то спецификацию не добавляем*/
        if (param.getSearchValue()!=null){
            if(param.getSearchField().equals("id")){
                spec= Specification.where(ProfileSpecification.valueLikeLong(param.getSearchField(), Long.parseLong(param.getSearchValue())));
            }else{
                spec= Specification.where(ProfileSpecification.valueLike(param.getSearchField(), param.getSearchValue()));
            }
        }else{
            spec = Specification.where(null);
        }
        Specification<Profile> specStatus = Specification.where(ProfileSpecification.statusValue(param.getStatus()));
        Page<Profile> pageable = profileRepository.findAll(spec.and(specStatus), PageRequest.of(param.getPage()-1, param.getItemInPage(),sort));
        return pageable.map(ProfileGetAllDtoResponse::new);
    }

    @Override
    public void changeStatus(Long id, ProfileStatus status) {
        Query query = entityManager.createQuery(CHANGE_STATUS_QUERY);
        query.setParameter("status",status);
        query.setParameter("id",id);
        query.executeUpdate();
    }

    @Override
    public ProfileDto getProfileById(Long id) {
        Query query = entityManager.createQuery(GET_PROFILE);
        query.setParameter("id",id);
        ProfileDto profileDto = (ProfileDto) query.getSingleResult();
        profileDto.setEmail(authService.getEmailById(id));
        return profileDto;
    }
}
