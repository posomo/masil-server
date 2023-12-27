package com.posomo.masil.editorpick.infra.quierydsl;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.posomo.masil.editorpick.domain.EditorPick;
import com.posomo.masil.editorpick.domain.EditorPickQuerydsl;
import com.posomo.masil.editorpick.domain.QEditorPick;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class EditorPickRepositoryImpl extends QuerydslRepositorySupport implements EditorPickQuerydsl {
	private final JPAQueryFactory queryFactory;
	private QEditorPick editorPick = QEditorPick.editorPick;

	public EditorPickRepositoryImpl(JPAQueryFactory queryFactory) {
		super(EditorPick.class);
		this.queryFactory = queryFactory;
	}

	@Override
	public List<EditorPick> findLatestEditorPick(int count) {
		return queryFactory.selectFrom(editorPick)
			.leftJoin(editorPick.editorPickImageList)
			.leftJoin(editorPick.editorPickTagList).fetchJoin()
			.orderBy(editorPick.publishedAt.desc())
			.limit(count)
			.fetch();
	}
}
