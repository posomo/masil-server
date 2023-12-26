package com.posomo.masil.bar.infra.querydsl;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.posomo.masil.bar.domain.Bar;
import com.posomo.masil.bar.domain.BarQuerydsl;
import com.posomo.masil.bar.domain.QBar;
import com.posomo.masil.bar.domain.vo.QBarKeyword;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class BarRepositoryImpl extends QuerydslRepositorySupport implements BarQuerydsl {
	private final JPAQueryFactory queryFactory;
	private final QBar bar = QBar.bar;
	private final QBarKeyword barKeyword = QBarKeyword.barKeyword;

	public BarRepositoryImpl(JPAQueryFactory queryFactory) {
		super(Bar.class);
		this.queryFactory = queryFactory;
	}

	@Override
	public List<Bar> findBarListByKeyword(String keyword, int limit) {
		return queryFactory.
			selectFrom(bar)
			.join(bar.keywords, barKeyword).fetchJoin()
			.leftJoin(bar.photos).fetchJoin()
			.where(barKeyword.name.eq(keyword)
				.and(barKeyword.count.gt(100)))
			.limit(limit)
			.fetch();

	}
}
