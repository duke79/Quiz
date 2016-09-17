package com.baliyaan.android.quiz.test.model.entity;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.baliyaan.android.quiz.test.model.dao.AnswerDao;

@Root
@DatabaseTable(daoClass = AnswerDao.class)
public class Answer {

	/** Name of exercise id field. */
	public static final String EXERCISE_ID_FIELD_NAME = "exercise_id";

	/** Answer id. */
	@DatabaseField(generatedId = true)
	private int id;

	/** Answer value. */
	@Text
	@DatabaseField(canBeNull = false)
	private String value;

	/** Determines if answer is valid. */
	@Attribute(required = false)
	@DatabaseField
	private boolean valid;

	/** The exercise to which answer belongs. */
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = EXERCISE_ID_FIELD_NAME)
	private Exercise exercise;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", value=" + value + ", valid=" + valid + ", exercise=" + exercise + "]";
	}

}
