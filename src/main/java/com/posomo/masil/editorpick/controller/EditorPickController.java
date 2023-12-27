package com.posomo.masil.editorpick.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.posomo.masil.editorpick.application.EditorPickService;
import com.posomo.masil.editorpick.dto.LatestEditorPickResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/editorpick")
@RequiredArgsConstructor
public class EditorPickController {
	private final EditorPickService editorPickService;

	@GetMapping("/recent/{count}")
	public List<LatestEditorPickResponseDto> getLatestEditorPickList(@PathVariable int count) {
		return editorPickService.getLatestEditorPickList(count);
	}
}
