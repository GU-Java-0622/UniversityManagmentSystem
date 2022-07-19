package com.karalexsandr.coreservice.repository.specifications;

import com.karalexsandr.coreservice.entity.News;
import org.springframework.data.jpa.domain.Specification;

public class NewsSpecifications {
    public static Specification<News> titleLike(String titlePart){
return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("title"),String.format("%%%s%%", titlePart)));
    }
}
