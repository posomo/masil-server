package com.posomo.masil.bar.domain.vo;

import com.posomo.masil.bar.domain.Bar;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BarMenu {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Integer price;
  @ManyToOne
  private Bar bar;
}
