package com.posomo.masil.query.map;

import com.posomo.masil.entity.Bar;
import com.posomo.masil.query.map.dto.BarImages;
import com.posomo.masil.query.map.dto.MapBarDto;
import com.posomo.masil.query.map.dto.MapFilterRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface MapBarMapper {
  @SelectProvider(type = FilterQueryBuilder.class, method = "buildFilter")
  public List<MapBarDto> findBarByFilter(MapFilterRequest filterRequest);

  @Select("SELECT bar_id,url FROM bar_photo WHERE bar_id in (${barIds})")
  List<BarImages> findPhotos(@Param("barIds") List<String> barIds);

}
