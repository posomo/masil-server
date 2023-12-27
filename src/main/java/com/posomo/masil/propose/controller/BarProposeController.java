package com.posomo.masil.propose.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.posomo.masil.propose.application.BarProposeService;
import com.posomo.masil.propose.controller.dto.BarProposeRequestDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/propose")
@RequiredArgsConstructor
public class BarProposeController {

	private final BarProposeService barProposeService;
	@PostMapping("/bar")
	public void proposeBar(@RequestBody BarProposeRequestDto barProposeRequestDto) {
		barProposeService.proposeBar(barProposeRequestDto);
	}
}
