package com.baliyaan.android.quiz.test.model.entity;

import java.util.Collection;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.baliyaan.android.quiz.test.model.dao.ExerciseDao;
import com.baliyaan.android.quiz.test.model.enums.AnswerType;
import com.baliyaan.android.quiz.test.model.enums.QuestionType;

@Root
@DatabaseTable(daoClass = ExerciseDao.class)
public class Exercise {

	// TODO add wrong answers count!

	public static final String LEVEL_ID_FIELD_NAME = "level_id";
	public static final String QUESTION_ID_FIELD_NAME = "question_id";

	/** Exercise id. */
	@DatabaseField(generatedId = true)
	private int id;

	/** Determines if exercise is solved or not. */
	@DatabaseField
	private boolean solved;

	/** Hint text. */
	@Element
	@DatabaseField
	private String tip;

	/** Determines if tip was used for this exercise. */
	@DatabaseField
	private boolean tipUsed;

	/** The level to which exercise belongs. */
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = LEVEL_ID_FIELD_NAME)
	private Level level;

	/** Type of question. */
	@Attribute(required = true)
	@DatabaseField(canBeNull = false)
	private QuestionType questionType;

	/** Question element. */
	@Element
	@DatabaseField(foreign = true, canBeNull = false, foreignAutoRefresh = true, columnName = QUESTION_ID_FIELD_NAME)
	private Question question;

	/** Type of answer. */
	@Attribute(required = true)
	@DatabaseField(canBeNull = false)
	private AnswerType answerType;

	/** Answers list */
	@ElementList
	@ForeignCollectionField
	private Collection<Answer> answers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isSolved() {
		return solved;
	}

	public void setSolved(boolean solved) {
		this.solved = solved;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public boolean isTipUsed() {
		return tipUsed;
	}

	public void setTipUsed(boolean tipUsed) {
		this.tipUsed = tipUsed;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public AnswerType getAnswerType() {
		return answerType;
	}

	public void setAnswerType(AnswerType answerType) {
		this.answerType = answerType;
	}

	public Collection<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Collection<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", solved=" + solved + ", tip=" + tip + ", tipUsed=" + tipUsed
				+ ", questionType=" + questionType + ", question=" + question + ", answerType=" + answerType
				+ ", answers=" + answers + "]";
	}

}
