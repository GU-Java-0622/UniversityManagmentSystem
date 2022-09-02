package ru.geekbrains.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.auth.entityes.User;
import ru.geekbrains.auth.payload.request.ProfileGetAllDtoRequest;
import ru.geekbrains.auth.payload.response.ProfileDto;
import ru.geekbrains.auth.payload.response.ProfileGetAllDtoResponse;
import ru.geekbrains.auth.repositories.UserRepository;
import ru.geekbrains.auth.repositories.specification.ProfileSpecification;
import ru.geekbrains.commons.entity.UserStatus;
import ru.geekbrains.commons.validators.FieldNameChecker;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final String CHANGE_STATUS_QUERY = "UPDATE User  set status=:status where id=:id";
    private final String GET_PROFILE = "SELECT new ru.geekbrains.auth.payload.response.ProfileDto(p.id,p.firstname,p.surname,p.middlename,p.email) from User as p" +
            " where p.id=:id";

    private final UserRepository profileRepository;

    private final EntityManager entityManager;


    @Override
    public Page<ProfileGetAllDtoResponse> getAllUsers(ProfileGetAllDtoRequest param) {
        if (param.getPage() == null) {
            param.setPage(1);
        }
        /*ASC по возрастанию Desc убывание*/
        Sort.Direction direction = Sort.Direction.ASC;
        if (!param.getDirectSort()) {
            direction = Sort.Direction.DESC;
        }
        Sort sort;
        String field = FieldNameChecker.checkFieldName(User.class, param.getSortField());
        if (field != null) {
            sort = Sort.by(direction, param.getSortField());
        } else {
            sort = Sort.by(direction, "id");
        }

        /*Добавляем спецификацию исходя из параметров запроса*/
        Specification<User> spec;
        /*Если строка запроа пуста то спецификацию не добавляем*/
        if (param.getSearchValue() != null) {
            if (param.getSearchField().equals("id")) {
                spec = Specification.where(ProfileSpecification.valueLikeLong(param.getSearchField(), Long.parseLong(param.getSearchValue())));
            } else {
                spec = Specification.where(ProfileSpecification.valueLike(param.getSearchField(), param.getSearchValue()));
            }
        } else {
            spec = Specification.where(null);
        }
        Specification<User> specStatus = Specification.where(ProfileSpecification.statusValue(param.getStatus()));
        Page<User> pageable = profileRepository.findAll(spec.and(specStatus), PageRequest.of(param.getPage() - 1, param.getItemInPage(), sort));
        return pageable.map(ProfileGetAllDtoResponse::new);
    }

    @Override
    public void changeStatus(Long id, UserStatus status) {
        Query query = entityManager.createQuery(CHANGE_STATUS_QUERY);
        query.setParameter("status", status);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public ProfileDto getProfileById(Long id) {
        Query query = entityManager.createQuery(GET_PROFILE);
        query.setParameter("id", id);
        return (ProfileDto) query.getSingleResult();
    }
}
