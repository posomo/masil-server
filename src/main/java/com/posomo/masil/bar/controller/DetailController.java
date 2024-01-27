package com.posomo.masil.bar.controller;

import com.posomo.masil.bar.application.BarService;
import com.posomo.masil.bar.dto.BarDetailResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detail")
@RequiredArgsConstructor
public class DetailController {
  private final BarService barService;
  public BarDetailResponseDto detail(@RequestParam(value = "vendor-id")String vendorId){

  }
}
