package com.posomo.masil.bar.domain;

import java.util.List;

public interface BarQuerydsl {
	List<Bar> findBarListByKeyword(String keyword, int limit);
}
