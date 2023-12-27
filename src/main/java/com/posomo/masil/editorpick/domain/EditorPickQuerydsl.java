package com.posomo.masil.editorpick.domain;

import java.util.List;

public interface EditorPickQuerydsl {
	List<EditorPick> findLatestEditorPick(int count);
}
