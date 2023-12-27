package com.posomo.masil.editorpick.dto;

import java.util.List;

import com.posomo.masil.editorpick.domain.EditorPick;
import com.posomo.masil.editorpick.domain.vo.EditorPickImage;
import com.posomo.masil.editorpick.domain.vo.EditorPickTag;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LatestEditorPickResponseDto {
	private String barVendorId;
	private String oneLineReview;
	private String commonAddress;
	private List<String> urlList;
	private List<String> tagList;

	public static LatestEditorPickResponseDto of(EditorPick editorPick) {
		List<String> urlList = editorPick.getEditorPickImageList().stream().map(EditorPickImage::getImageUrl).toList();
		List<String> tagList = editorPick.getEditorPickTagList().stream().map(EditorPickTag::getTag).toList();
		return new LatestEditorPickResponseDto(editorPick.getBarVendorId(),
			editorPick.getOneLineReview(),
			editorPick.getCommonAddress(),
			urlList,
			tagList);
	}
}
