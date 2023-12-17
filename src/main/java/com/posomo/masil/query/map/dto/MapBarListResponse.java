package com.posomo.masil.query.map.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MapBarListResponse {
  private int limit;
  private int offset;
  private List<MapBarResponse> bars;
  private boolean hasNext;
}
