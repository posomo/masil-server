package com.posomo.masil.ui.home.comtroller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.posomo.masil.ui.home.application.HomeUiService;
import com.posomo.masil.ui.home.comtroller.viewtype.ViewTypeObject;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ui")
@RequiredArgsConstructor
public class HomeController {
	private final HomeUiService homeUiService;
	@GetMapping("/home")
	public List<ViewTypeObject> getHomeUi() {
		return homeUiService.composeHomeUi();
	}
}
