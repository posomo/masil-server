package com.posomo.masil.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BarMapper {

  @Select("SELECT category,latitude FROM bar")
  List<SampleDto> getAllBars();
}
