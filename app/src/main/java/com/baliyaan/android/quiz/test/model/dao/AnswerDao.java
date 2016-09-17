
package com.baliyaan.android.quiz.test.model.dao;

import java.sql.SQLException;

import com.google.inject.Singleton;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.baliyaan.android.quiz.test.model.DatabaseHelper;
import com.baliyaan.android.quiz.test.model.entity.Answer;

@Singleton
public class AnswerDao extends BaseDaoImpl<Answer, Integer> {

	public AnswerDao() throws SQLException {
		super(DatabaseHelper.getConnectionSrc(), Answer.class);
	}

	public AnswerDao(Class<Answer> dataClass) throws SQLException {
		super(dataClass);
	}

	public AnswerDao(ConnectionSource connectionSource, Class<Answer> dataClass) throws SQLException {
		super(connectionSource, dataClass);
	}

	public AnswerDao(ConnectionSource connectionSource, DatabaseTableConfig<Answer> tableConfig) throws SQLException {
		super(connectionSource, tableConfig);
	}

}
