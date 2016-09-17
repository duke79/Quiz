package com.baliyaan.android.quiz.test.model.dao;

import java.sql.SQLException;

import roboguice.inject.InjectResource;
import android.util.Log;

import com.google.inject.Singleton;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.baliyaan.android.quiz.test.R;
import com.baliyaan.android.quiz.test.model.DatabaseHelper;
import com.baliyaan.android.quiz.test.model.entity.Exercise;

@Singleton
public class ExerciseDao extends BaseDaoImpl<Exercise, Integer> {

	/** Application name. */
	@InjectResource(R.string.app_name)
	private String applicationName;

	/** Error string. */
	@InjectResource(R.string.error)
	private String errorString;

	public ExerciseDao() throws SQLException {
		super(DatabaseHelper.getConnectionSrc(), Exercise.class);
	}

	public ExerciseDao(Class<Exercise> dataClass) throws SQLException {
		super(dataClass);
	}

	public ExerciseDao(ConnectionSource connectionSource, Class<Exercise> dataClass) throws SQLException {
		super(connectionSource, dataClass);
	}

	public ExerciseDao(ConnectionSource connectionSource, DatabaseTableConfig<Exercise> tableConfig)
			throws SQLException {
		super(connectionSource, tableConfig);
	}

	/* (non-Javadoc)
	 * @see com.j256.ormlite.dao.BaseDaoImpl#update(java.lang.Object)
	 */
	@Override
	public int update(Exercise arg0) {
		try {
			return super.update(arg0);
		} catch (SQLException e) {
			Log.e(applicationName, errorString, e);
			return 0;
		}
	}

}
