package com.posomo.masil.query.map.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MapFilterRequest {
  private List<String> keywords;
  private List<String> drinkCategories;
  private List<String> barCategories;
  private int limit;
  private int offset;
}
