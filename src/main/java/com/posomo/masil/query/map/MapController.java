package com.posomo.masil.query.map;

import com.posomo.masil.entity.Bar;
import com.posomo.masil.query.map.dto.MapBarDto;
import com.posomo.masil.query.map.dto.MapBarListResponse;
import com.posomo.masil.query.map.dto.MapFilterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MapController {
  private final MapBarMapper mapper;
  @PostMapping("/map")
  public String getMapBars(@RequestBody MapFilterRequest filterRequest){
    List<MapBarDto> bars = mapper.findBarByFilter(filterRequest);;
    return "ok";
  }
}
