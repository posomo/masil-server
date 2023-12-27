package com.posomo.masil.editorpick.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface EditorPickRepository extends JpaRepository<EditorPick, Long>, EditorPickQuerydsl, QuerydslPredicateExecutor<EditorPick> {
}
