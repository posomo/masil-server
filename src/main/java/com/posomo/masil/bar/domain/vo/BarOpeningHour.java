package com.posomo.masil.bar.domain.vo;

import java.time.ZonedDateTime;

import com.posomo.masil.bar.domain.Bar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BarOpeningHour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Boolean monday;
	private Boolean tuesday;
	private Boolean wednesday;
	private Boolean thursday;
	private Boolean friday;
	private Boolean saturday;
	private Boolean sunday;
	private String type;
	@JoinColumn(name = "bar_vendor_id")
	@ManyToOne
	private Bar bar;
	private ZonedDateTime startTime;
	private ZonedDateTime endTime;
}
