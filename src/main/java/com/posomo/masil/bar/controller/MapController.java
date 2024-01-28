package com.posomo.masil.bar.controller;

import com.posomo.masil.bar.application.BarService;
import com.posomo.masil.bar.domain.Bar;
import com.posomo.masil.bar.dto.MapBarResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/map")
@RequiredArgsConstructor
public class MapController {
  private final BarService barService;
  @GetMapping("/home")
  public List<MapBarResponseDto> showMap(@RequestParam(value = "longitude")Double longitude,
                                         @RequestParam(value = "latitude")Double latitude,
                                         @RequestParam(value = "distance")Double distance){
    int limit=30;
    List<Bar> barList = barService.retrieveBarForMap(longitude,latitude,distance,limit);
    return barList.stream().map(MapBarResponseDto::of).toList();
  }
}
