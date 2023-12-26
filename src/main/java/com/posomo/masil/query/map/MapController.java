package com.posomo.masil.query.map;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.posomo.masil.query.map.dto.MapBarDto;
import com.posomo.masil.query.map.dto.MapFilterRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MapController {
	private final MapBarMapper mapper;

	@PostMapping("/map")
	public String getMapBars(@RequestBody MapFilterRequest filterRequest) {
		List<MapBarDto> bars = mapper.findBarByFilter(filterRequest);
		return "ok";
	}
}
