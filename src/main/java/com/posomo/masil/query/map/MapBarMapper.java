package com.posomo.masil.query.map;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import com.posomo.masil.query.map.dto.MapBarDto;
import com.posomo.masil.query.map.dto.MapFilterRequest;

@Mapper
public interface MapBarMapper {
	@SelectProvider(type = FilterQueryBuilder.class, method = "buildFilter")
	List<MapBarDto> findBarByFilter(MapFilterRequest filterRequest);
}
