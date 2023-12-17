package com.posomo.masil.query.map;

import com.posomo.masil.entity.Bar;
import com.posomo.masil.query.map.dto.MapFilterRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface MapBarMapper {
  @SelectProvider(type = FilterQueryBuilder.class, method = "buildFilter")
  public List<Bar> findBarByFilter(MapFilterRequest filterRequest);
}
