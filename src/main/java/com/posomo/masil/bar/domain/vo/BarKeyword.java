package com.posomo.masil.bar.domain.vo;

import com.posomo.masil.bar.domain.Bar;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BarKeyword {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private String name;
  private Integer count;
  @ManyToOne
  private Bar bar;
}
