package com.posomo.masil.ui.home.comtroller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.posomo.masil.ui.home.comtroller.viewtype.ViewTypeObject;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ui")
@RequiredArgsConstructor
public class HomeController {

	@GetMapping("/home")
	public List<ViewTypeObject> getHomeUi() {
		return null;
	}
}
