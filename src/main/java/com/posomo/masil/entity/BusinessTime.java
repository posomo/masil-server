package com.posomo.masil.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class BusinessTime {
  private Integer mondayStartTime;
  private Integer mondayEndTime;
  private Integer tuesdayStartTime;
  private Integer tuesdayEndTime;
  private Integer wednesdayStartTime;
  private Integer wednesdayEndTime;
  private Integer thursdayStartTime;
  private Integer thursdayEndTime;
  private Integer fridayStartTime;
  private Integer fridayEndTime;
  private Integer saturdayStartTime;
  private Integer saturdayEndTime;
  private Integer sundayStartTime;
  private Integer sundayEndTime;
}
