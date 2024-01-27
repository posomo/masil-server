package com.posomo.masil.bar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BarDetailResponseDto {
  private String name;
  private List<String> photos;
  private String roadAddress;
  private String localAddress;
  private String commonAddress;
  private OpeningHour openingHour;
  private List<String> keywords;
  private String category;
  private List<MenuInfo> menus;

  private static class OpeningHour{
    private String[] openTime = new String[7];
    private String[] closeTime = new String[7];
  }
  private static class MenuInfo{
    private String name;
    private String description;
    private Integer price;
  }

}
