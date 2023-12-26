package com.posomo.masil.bar.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.posomo.masil.bar.domain.Bar;
import com.posomo.masil.bar.domain.BarRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BarService {

	private final BarRepository barRepository;

	public List<Bar> retrieveBarWithKeyword(String keyword, int limit) {
		List<Bar> barListByKeyword = barRepository.findBarListByKeyword(keyword, limit);
		log.info(barListByKeyword.toString());
		return barListByKeyword;
	}
}
