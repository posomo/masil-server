package com.posomo.masil.global;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
  @ExceptionHandler(RuntimeException.class)
  public String runtimeHandle(RuntimeException exception){
    return "서버에서 예외가 발생했습니다.";
  }
}
