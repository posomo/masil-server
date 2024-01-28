package com.posomo.masil.bar.application;

import java.util.List;

import com.posomo.masil.bar.domain.vo.BarOpeningHour;
import com.posomo.masil.bar.dto.MapBarResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.posomo.masil.bar.domain.Bar;
import com.posomo.masil.bar.domain.BarRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BarService {

	private final BarRepository barRepository;

	@Transactional(readOnly = true)
	public List<Bar> retrieveBarWithKeyword(String keyword, int limit) {
		List<Bar> barListByKeyword = barRepository.findBarListByKeyword(keyword, limit);
		log.info(barListByKeyword.toString());
		return barListByKeyword;
	}

	@Transactional(readOnly = true)
	public List<Bar> retrieveBarForMap(double longitude, double latitude, double distance, int limit){
		return barRepository.findBarByLocation(longitude,latitude,distance,limit);
	}

	@Transactional(readOnly = true)
	public Bar retrieveBarForDetail(String vendorId){
		return barRepository.findBarByIdJoinFetchAll(vendorId).orElseThrow(RuntimeException::new);
	}

	@Transactional(readOnly = true)
	public List<BarOpeningHour> openingHours(String vendorId){
		return barRepository.findOpeningHoursByVendorId(vendorId);
	}
}
