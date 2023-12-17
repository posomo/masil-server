package com.posomo.masil.query.map.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
  public static MapBarResponse of(MapBarDto b){
    List<String> list = new ArrayList<>();
    return new MapBarResponse(b.getId(),b.getName(),b.getCategory(),null,
            null, b.getCommonAddress(), list);
  }
  public void addImage(String imageUrl){
    this.images.add(imageUrl);
  }
}
