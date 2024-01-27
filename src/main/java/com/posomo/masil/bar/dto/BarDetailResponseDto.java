package com.posomo.masil.bar.dto;

import com.posomo.masil.bar.domain.Bar;
import com.posomo.masil.bar.domain.vo.BarKeyword;
import com.posomo.masil.bar.domain.vo.BarMenu;
import com.posomo.masil.bar.domain.vo.BarOpeningHour;
import com.posomo.masil.bar.domain.vo.BarPhoto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BarDetailResponseDto {
  private String vendorId;
  private String name;
  private List<String> photos;
  private String roadAddress;
  private String localAddress;
  private String commonAddress;
  private OpeningHour openingHour;
  private List<String> keywords;
  private String category;
  private List<MenuInfo> menus;

  public static BarDetailResponseDto of(Bar b, List<BarOpeningHour> openingHours){
    List<String> photoUrls = b.getPhotos().stream().map(BarPhoto::getUrl).toList();
    List<String> keywords = b.getKeywords().stream().map(BarKeyword::getName).toList();
    List<MenuInfo> menus = b.getMenus().stream().map(MenuInfo::of).toList();
    return new BarDetailResponseDto(b.getVendorId(),b.getName(),photoUrls,b.getAddress().getRoadAddress(),
            b.getAddress().getLocalAddress(),b.getAddress().getCommonAddress(),OpeningHour.of(openingHours),
            keywords,b.getCategory(), menus);
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  private static class OpeningHour{
    private String[] openTime = new String[7];
    private String[] closeTime = new String[7];
    public static OpeningHour of(List<BarOpeningHour> bo){
      List<BarOpeningHour> workingHours = bo.stream().filter((h)->h.getType().equals("영업시간")).toList();
      List<String> opening = new ArrayList<>();
      List<String> closing = new ArrayList<>();
      opening.add(openingTime(workingHours,BarOpeningHour::getMonday));
      opening.add(openingTime(workingHours,BarOpeningHour::getTuesday));
      opening.add(openingTime(workingHours,BarOpeningHour::getWednesday));
      opening.add(openingTime(workingHours,BarOpeningHour::getThursday));
      opening.add(openingTime(workingHours,BarOpeningHour::getFriday));

      closing.add(closingTime(workingHours,BarOpeningHour::getMonday));
      closing.add(closingTime(workingHours,BarOpeningHour::getTuesday));
      closing.add(closingTime(workingHours,BarOpeningHour::getWednesday));
      closing.add(closingTime(workingHours,BarOpeningHour::getThursday));
      closing.add(closingTime(workingHours,BarOpeningHour::getFriday));
      return new OpeningHour(opening.toArray(new String[7]),closing.toArray(new String[7]));
    }
    public static String openingTime(List<BarOpeningHour> workingHours, Predicate<BarOpeningHour> predicate){
      return workingHours.stream().filter(predicate).findAny()
              .map((h)->h.getStartTime()==null ? null:h.getStartTime().format(DateTimeFormatter.ofPattern("HH:mm")))
              .get();
    }
    public static String closingTime(List<BarOpeningHour> workingHours, Predicate<BarOpeningHour> predicate){
      return workingHours.stream().filter(predicate).findAny()
              .map((h)->h.getStartTime()==null ? null:h.getEndTime().format(DateTimeFormatter.ofPattern("HH:mm")))
              .get();
    }
  }
  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  private static class MenuInfo{
    private String name;
    private String description;
    private Integer price;
    public static MenuInfo of(BarMenu bm){
      return new MenuInfo(bm.getName(),null,bm.getPrice());
    }
  }

}
