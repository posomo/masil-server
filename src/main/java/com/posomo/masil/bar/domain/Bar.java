package com.posomo.masil.bar.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

import com.posomo.masil.bar.domain.vo.Address;
import com.posomo.masil.bar.domain.vo.BarPhoto;
import com.posomo.masil.bar.domain.vo.BarKeyword;
import com.posomo.masil.bar.domain.vo.BarMenu;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Bar {
  private String name;
  @Id
  private String vendorId;
  @OneToMany(mappedBy = "bar")
  private List<BarPhoto> photos;
  @OneToMany(mappedBy = "bar")
  private List<BarMenu> menus;
  @OneToMany(mappedBy = "bar")
  private Set<BarKeyword> keywords;
  private String phoneNumber;
  private Double latitude;
  private Double longitude;
  private String category;
  private Double starRating;
  private String description;
  @Embedded
  private Address address;
}
