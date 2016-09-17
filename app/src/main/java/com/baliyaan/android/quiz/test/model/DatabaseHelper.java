package com.baliyaan.android.quiz.test.model;

import java.util.ArrayList;
import java.util.List;

import roboguice.RoboGuice;
import roboguice.inject.InjectResource;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.inject.Inject;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.baliyaan.android.quiz.test.QuizApplication;
import com.baliyaan.android.quiz.test.R;
import com.baliyaan.android.quiz.test.model.dao.AnswerDao;
import com.baliyaan.android.quiz.test.model.dao.ExerciseDao;
import com.baliyaan.android.quiz.test.model.dao.LevelDao;
import com.baliyaan.android.quiz.test.model.dao.QuestionDao;
import com.baliyaan.android.quiz.test.model.dao.ScoringDao;
import com.baliyaan.android.quiz.test.model.entity.Answer;
import com.baliyaan.android.quiz.test.model.entity.Exercise;
import com.baliyaan.android.quiz.test.model.entity.Level;
import com.baliyaan.android.quiz.test.model.entity.Question;
import com.baliyaan.android.quiz.test.model.entity.Quiz;
import com.baliyaan.android.quiz.test.model.entity.Scoring;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private static final String DATABASE_FILE_NAME = "quizes.sqlite";

	/**
	 * Any time changes are made to database objects, may
	 * have to increase the database version.
	 */
	private static final int DATABASE_VERSION = 1;

	private static DatabaseHelper instance = new DatabaseHelper(QuizApplication.getContext());

	private Context applicationContext;

	@Inject
	private LevelDao levelDao;

	@Inject
	private ExerciseDao exerciseDao;

	@Inject
	private QuestionDao questionDao;

	@Inject
	private AnswerDao answerDao;

	@Inject
	private ScoringDao scoringDao;

	@InjectResource(R.string.app_name)
	private String applicationName;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
		this.applicationContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource cs) {
		try {
			createDataBase(cs);
			// Inject manually since only RoboActivity can
			// do it by itself.
			RoboGuice.injectMembers(applicationContext, this);
			loadContentToDataBase();
		} catch (SQLException e) {
			Log.e(applicationName, "Can't create database!", e);
			throw new RuntimeException(e);
		} catch (java.sql.SQLException e) {
			Log.e(applicationName, "Error while creating DB!", e);
		} catch (Exception e) {
			Log.e(applicationName, "Cannot load XML to DB!", e);
		}

	}

	private void loadContentToDataBase() throws Exception, java.sql.SQLException {
		Quiz quiz = new XmlDataLoader(applicationContext).loadXml();
		// Children first than parents.
		for (Level level : quiz.getLevels()) {
			for (Exercise exercise : level.getExercises()) {
				exercise.setLevel(level);
				questionDao.create(exercise.getQuestion());
				questionDao.refresh(exercise.getQuestion());
				exerciseDao.create(exercise);
				for (Answer answer : exercise.getAnswers()) {
					answer.setExercise(exercise);
					answerDao.create(answer);
				}
			}
			Scoring scoring = level.getScoring();
			scoring.setLevel(level);
			scoringDao.create(scoring);
			levelDao.create(level);
		}
	}

	private void createDataBase(ConnectionSource cs) throws java.sql.SQLException {
		TableUtils.createTable(cs, Level.class);
		TableUtils.createTable(cs, Exercise.class);
		TableUtils.createTable(cs, Question.class);
		TableUtils.createTable(cs, Answer.class);
		TableUtils.createTable(cs, Scoring.class);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource cs, int oldVersion, int newVersion) {
		try {
			List<String> allSql = new ArrayList<String>();
			// DB upgrade can depend on version is upgrading
			// from
			switch (oldVersion) {
			case 1:
				// allSql.add("SQL query 1 here");
				// allSql.add("SQL query 2 here");
			}
			for (String sql : allSql) {
				db.execSQL(sql);
			}
		} catch (SQLException e) {
			Log.e(applicationName, "Exception during DB upgrade!", e);
			throw new RuntimeException(e);
		}

	}

	/**
	 * Returns {@link ConnectionSource} object.
	 * 
	 * @return {@link ConnectionSource} object
	 */
	public static ConnectionSource getConnectionSrc() {
		return instance.getConnectionSource();
	}
}
