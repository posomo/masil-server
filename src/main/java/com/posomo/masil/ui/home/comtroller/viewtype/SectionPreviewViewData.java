package com.posomo.masil.ui.home.comtroller.viewtype;

import java.util.List;

import com.posomo.masil.bar.domain.Bar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionPreviewViewData implements ViewTypeData {
	private String sectionTitle;
	private List<BarItem> barItemList;

	public static SectionPreviewViewData of(String sectionTitle, List<Bar> barList) {
		return new SectionPreviewViewData(
			sectionTitle,
			barList.stream().map(BarItem::of).toList()
		);
	}
	@Data
	@AllArgsConstructor
	public static class BarItem {
		private String imageUrl;
		private String barName;
		private String barCommonAddress;
		private String category;

		public static BarItem of(Bar bar) {
			String photoUrl = bar.getPhotos().isEmpty() ? "" : bar.getPhotos().get(0).getUrl();
			return new BarItem(
				photoUrl,
				bar.getName(),
				bar.getAddress().getCommonAddress(),
				bar.getCategory()
			);
		}
	}
}
