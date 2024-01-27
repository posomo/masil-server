package com.posomo.masil.bar.controller;

import com.posomo.masil.bar.application.BarService;
import com.posomo.masil.bar.domain.Bar;
import com.posomo.masil.bar.domain.vo.BarOpeningHour;
import com.posomo.masil.bar.dto.BarDetailResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/detail")
@RequiredArgsConstructor
public class DetailController {
  private final BarService barService;
  public BarDetailResponseDto detail(@RequestParam(value = "vendor-id")String vendorId){
    Bar bar = barService.retrieveBarForDetail(vendorId);
    List<BarOpeningHour> openingHour = barService.openingHours(vendorId);
    return BarDetailResponseDto.of(bar,openingHour);
  }
}
