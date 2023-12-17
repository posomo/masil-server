package com.posomo.masil.query.detail;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailController {
  @GetMapping("/api/detail")
  public String detail(){
    return "hello";
  }
}
