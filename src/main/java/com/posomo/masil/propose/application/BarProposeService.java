package com.posomo.masil.propose.application;

import org.springframework.stereotype.Service;

import com.posomo.masil.propose.controller.dto.BarProposeRequestDto;
import com.posomo.masil.propose.domain.BarPropose;
import com.posomo.masil.propose.domain.BarProposeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BarProposeService {

	private final BarProposeRepository barProposeRepository;

	public void proposeBar(BarProposeRequestDto barProposeRequestDto) {
		BarPropose barPropose = barProposeRequestDto.mapToDomain();
		barProposeRepository.save(barPropose);
	}
}
