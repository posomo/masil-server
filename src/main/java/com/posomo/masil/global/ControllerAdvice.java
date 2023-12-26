package com.posomo.masil.global;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {
	@ExceptionHandler(RuntimeException.class)
	public String runtimeHandle(RuntimeException exception) {
		log.error("서버에서 예외가 발생했습니다", exception);
		return "서버에서 예외가 발생했습니다.";
	}
}
