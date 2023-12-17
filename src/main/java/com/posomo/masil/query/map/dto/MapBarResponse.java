package com.posomo.masil.query.map.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MapBarResponse {
  private String barId;
  private String name;
  private String category;
  private Boolean isOpen;
  private Boolean isBookMarked;
  private String commonAddress;
  private List<String> images;
}
