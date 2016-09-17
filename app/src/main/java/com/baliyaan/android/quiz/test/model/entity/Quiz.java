package com.baliyaan.android.quiz.test.model.entity;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Quiz {

	/** List of levels. */
	@ElementList
	private List<Level> levels;

	public List<Level> getLevels() {
		return levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}

	@Override
	public String toString() {
		return "Quiz [levels=" + levels + "]";
	}

}
