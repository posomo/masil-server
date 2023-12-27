package com.posomo.masil.editorpick.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.posomo.masil.editorpick.domain.EditorPick;
import com.posomo.masil.editorpick.domain.EditorPickRepository;
import com.posomo.masil.editorpick.dto.LatestEditorPickResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EditorPickService {

	private final EditorPickRepository editorPickRepository;

	@Transactional(readOnly = true)
	public List<LatestEditorPickResponseDto> getLatestEditorPickList(int count) {
		List<EditorPick> latestEditorPickList = editorPickRepository.findLatestEditorPick(count);
		return latestEditorPickList.stream().map(LatestEditorPickResponseDto::of).toList();
	}
}
