package com.posomo.masil.bar.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BarRepository extends JpaRepository<Bar, String>, BarQuerydsl, QuerydslPredicateExecutor<Bar> {
  @Query(value = "select * from Bar b where ST_DISTANCE_SPHERE(POINT(:longitude,:latitude)," +
          "POINT(b.longitude,b.latitude))<=:distance limit :limit_count",nativeQuery = true)
  List<Bar> findBarByLocation(@Param(value = "longitude")Double longitude,@Param(value = "latitude")Double latitude,
                              @Param(value = "distance")Double distance,@Param(value = "limit_count")Integer limit);
}
