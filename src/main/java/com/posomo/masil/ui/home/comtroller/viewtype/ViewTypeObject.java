package com.posomo.masil.ui.home.comtroller.viewtype;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewTypeObject {
	private String viewType;
	private List<String> deeplink;
	private ViewTypeData data;
}
