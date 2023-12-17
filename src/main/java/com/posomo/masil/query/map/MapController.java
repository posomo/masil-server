package com.posomo.masil.query.map;

import com.posomo.masil.entity.Bar;
import com.posomo.masil.query.map.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MapController {
  private final MapBarMapper mapper;
  @PostMapping("/map")
  public MapBarListResponse getMapBars(@RequestBody MapFilterRequest filterRequest){
    List<MapBarDto> bars = mapper.findBarByFilter(filterRequest);
    List<String> ids = bars.stream().map(MapBarDto::getId).toList();
    List<BarImages> images = mapper.findPhotos(ids);
    Map<String, MapBarResponse> barDtoMap = new HashMap<>();

    List<MapBarResponse> response = bars.stream().map(MapBarResponse::of).toList();
    for(MapBarResponse b : response)
      barDtoMap.put(b.getBarId(),b);
    for(BarImages i : images){
      MapBarResponse bar = barDtoMap.get(i.getBarId());
      if(bar.getImages().size()<3)
        bar.addImage(i.getImageUrl());
    }

    return new MapBarListResponse(filterRequest.getLimit(),filterRequest.getOffset(),
            response, response.size() >= filterRequest.getOffset());
  }
}
