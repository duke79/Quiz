package com.baliyaan.android.quiz.test.model.dao;

import java.sql.SQLException;

import com.google.inject.Singleton;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.baliyaan.android.quiz.test.model.DatabaseHelper;
import com.baliyaan.android.quiz.test.model.entity.Question;

@Singleton
public class QuestionDao extends BaseDaoImpl<Question, Integer> {

	public QuestionDao() throws SQLException {
		super(DatabaseHelper.getConnectionSrc(), Question.class);
	}

	public QuestionDao(Class<Question> dataClass) throws SQLException {
		super(dataClass);
	}

	public QuestionDao(ConnectionSource connectionSource, Class<Question> dataClass) throws SQLException {
		super(connectionSource, dataClass);
	}

	public QuestionDao(ConnectionSource connectionSource, DatabaseTableConfig<Question> tableConfig)
			throws SQLException {
		super(connectionSource, tableConfig);
	}

}
