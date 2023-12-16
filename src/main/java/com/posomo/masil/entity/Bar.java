package com.posomo.masil.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Bar {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String vendorId;
  @OneToMany(mappedBy = "bar")
  private List<BarPhoto> photos;
  @OneToMany(mappedBy = "bar")
  private List<BarMenu> menus;
  @OneToMany(mappedBy = "bar")
  private List<BarKeyword> keywords;
  @Embedded
  private BusinessTime businessTime;
  @Embedded
  private Address address;
  private String phoneNumber;
  private Double latitude;
  private Double longitude;
  private String category;
  private Double starRating;
  private String description;
}
