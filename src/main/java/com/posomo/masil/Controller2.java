package com.posomo.masil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {

	@GetMapping("/")
	public String test() {
		return "Hello2";
	}
}
