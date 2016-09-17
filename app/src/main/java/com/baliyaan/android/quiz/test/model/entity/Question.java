package com.baliyaan.android.quiz.test.model.entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.baliyaan.android.quiz.test.model.dao.QuestionDao;

@Root
@DatabaseTable(daoClass = QuestionDao.class)
public class Question {

	/** Question id. */
	@DatabaseField(generatedId = true)
	private int id;

	/** Question image. */
	@Element(required = false)
	@DatabaseField
	private String image;

	/** Question text. */
	@Element(required = false)
	@DatabaseField
	private String text;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", image=" + image + ", text=" + text + "]";
	}

}
