package com.posomo.masil.bar.domain.vo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

import com.posomo.masil.bar.domain.Bar;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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
  @ManyToOne
  private Bar bar;
  private ZonedDateTime startTime;
  private ZonedDateTime endTime;
}
