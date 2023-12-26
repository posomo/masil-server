package com.posomo.masil.ui.home.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.posomo.masil.bar.application.BarService;
import com.posomo.masil.ui.home.comtroller.viewtype.SectionPreviewViewData;
import com.posomo.masil.ui.home.comtroller.viewtype.ViewTypeObject;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeUiService {
	private final BarService barService;

	public List<ViewTypeObject> composeHomeUi() {
		ViewTypeObject firstViewTypeObject = createSectionPreviewViewObject("가성비가 좋아요", 10);
		ViewTypeObject secondViewTypeObject = createSectionPreviewViewObject("혼술하기 좋아요", 10);
		ViewTypeObject recommendPlace = new ViewTypeObject("RecommendPlaceView", new ArrayList<>(), null);
		ViewTypeObject thirdViewTypeObject = createSectionPreviewViewObject("음식이 맛있어요", 10);
		return List.of(firstViewTypeObject, secondViewTypeObject, recommendPlace, thirdViewTypeObject);
	}

	private ViewTypeObject createSectionPreviewViewObject(String keyword, int limit) {
		SectionPreviewViewData data = SectionPreviewViewData.of(
			keyword,
			barService.retrieveBarWithKeyword(keyword, limit)
		);
		// TODO: deeplink
		return new ViewTypeObject("SectionPreviewView", new ArrayList<>(), data);
	}
}
