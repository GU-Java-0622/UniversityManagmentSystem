package ru.geekbrains.com.repositories.specification;


import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.com.entity.Profile;
import ru.geekbrains.com.entity.ProfileStatus;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Set;

public class ProfileSpecification {
    public static Specification<Profile> valueLike(String field, String value) {
        return (Root<Profile> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> criteriaBuilder.like(root.get(field), String.format("%%%s%%", value));
    }
    public static Specification<Profile> valueLikeLong(String field, Long value) {
        return (Root<Profile> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> criteriaBuilder.like(root.get(field).as(String.class), String.format("%%%s%%", value));
    }
    public static Specification<Profile> statusValue( Set<ProfileStatus> value) {
        return (Root<Profile> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> criteriaBuilder.in(root.get("status")).value(value);
    }
}
