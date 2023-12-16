package com.posomo.masil.mapper;

import com.posomo.masil.entity.Bar;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SampleController {
  private final BarMapper barMapper;
  @GetMapping("sample")
  public String sample(){
    List<SampleDto> dtos = barMapper.getAllBars();
    return String.valueOf(dtos.size());
  }
}
