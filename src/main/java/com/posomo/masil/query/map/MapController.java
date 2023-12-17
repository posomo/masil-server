package com.posomo.masil.query.map;

import com.posomo.masil.bar.domain.Bar;
import com.posomo.masil.query.map.dto.MapFilterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MapController {
  private final MapBarMapper mapper;
  @PostMapping("/map")
  public String getMapBars(@RequestBody MapFilterRequest filterRequest){
    List<Bar> bars = mapper.findBarByFilter(filterRequest);;
    return "ok";
  }
}
