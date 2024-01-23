package com.posomo.masil.bar.dto;

import com.posomo.masil.bar.domain.Bar;
import com.posomo.masil.bar.domain.vo.BarPhoto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MapBarResponseDto {
  private String vendorId;
  private String name;
  private String localAddress;
  private String category;
  private List<String> photos;

  public static MapBarResponseDto of(Bar bar){
    return new MapBarResponseDto(bar.getVendorId(),bar.getName(),bar.getAddress().getLocalAddress(),
            bar.getCategory(),bar.getPhotos().stream().map(BarPhoto::getUrl).toList());
  }
}
