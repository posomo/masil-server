package com.posomo.masil.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BarKeyword {
  @Id
  private String id;
  @ManyToOne
  private Keyword keyword;
  private String name;
  @ManyToOne
  private Bar bar;
}
