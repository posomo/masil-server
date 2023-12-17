package com.posomo.masil.bar.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BarRepository extends JpaRepository<Bar, Long>, BarQueryDsl, QuerydslPredicateExecutor<Bar> {
}
