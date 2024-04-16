package com.sulimann.cleanarch.infra.adapters.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sulimann.cleanarch.core.utils.specification.ISpecification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class SpecificationAdapter<T> implements ISpecification<T>{

  private final Specification<T> specification;

  public SpecificationAdapter(Specification<T> specification) {
    this.specification = specification;
  }

  @Override
  public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
      CriteriaBuilder criteriaBuilder) {
    return this.specification.toPredicate(root, query, criteriaBuilder);
  }


}
