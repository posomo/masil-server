package com.posomo.masil.editorpick.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.posomo.masil.editorpick.domain.vo.EditorPickImage;
import com.posomo.masil.editorpick.domain.vo.EditorPickTag;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

@Entity
@Getter
public class EditorPick {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String barVendorId;
	private String oneLineReview;
	@Column(columnDefinition = "TEXT")
	private String mainText;
	private String commonAddress;
	private String editorName;
	private LocalDateTime publishedAt;

	@OneToMany(mappedBy = "editorPick", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EditorPickImage> editorPickImageList;
	@OneToMany(mappedBy = "editorPick", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EditorPickTag> editorPickTagList;
}
