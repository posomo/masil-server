package com.posomo.masil.bar.domain.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {
  private String roadAddress;
  private String localAddress;
  private String commonAddress;
}
