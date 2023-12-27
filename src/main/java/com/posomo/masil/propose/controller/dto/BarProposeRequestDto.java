package com.posomo.masil.propose.controller.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.posomo.masil.propose.domain.BarPropose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BarProposeRequestDto {
	private String name;
	private String commonAddress;
	private String description;
	private List<String> keywords;

	public BarPropose mapToDomain() {
		return BarPropose.builder()
			.name(name)
			.commonAddress(commonAddress)
			.description(description)
			.keywords(String.join(",", keywords))
			.proposedAt(LocalDateTime.now())
			.build();
	}
}
