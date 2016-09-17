package com.baliyaan.android.quiz.test.model.dao;

import java.sql.SQLException;

import roboguice.RoboGuice;
import roboguice.inject.InjectResource;
import android.util.Log;

import com.google.inject.Singleton;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.baliyaan.android.quiz.test.QuizApplication;
import com.baliyaan.android.quiz.test.R;
import com.baliyaan.android.quiz.test.model.DatabaseHelper;
import com.baliyaan.android.quiz.test.model.entity.Scoring;

@Singleton
public class ScoringDao extends BaseDaoImpl<Scoring, Integer> {

	/** Application name. */
	@InjectResource(R.string.app_name)
	private String applicationName;

	/** Error string. */
	@InjectResource(R.string.error)
	private String errorString;

	public ScoringDao() throws SQLException {
		super(DatabaseHelper.getConnectionSrc(), Scoring.class);
		RoboGuice.injectMembers(QuizApplication.getContext(), this);
	}

	public ScoringDao(Class<Scoring> dataClass) throws SQLException {
		super(dataClass);
	}

	public ScoringDao(ConnectionSource connectionSource, Class<Scoring> dataClass) throws SQLException {
		super(connectionSource, dataClass);
	}

	public ScoringDao(ConnectionSource connectionSource, DatabaseTableConfig<Scoring> tableConfig) throws SQLException {
		super(connectionSource, tableConfig);
	}

	/* (non-Javadoc)
	 * @see com.j256.ormlite.dao.BaseDaoImpl#update(java.lang.Object)
	 */
	@Override
	public int update(Scoring arg0) {
		try {
			return super.update(arg0);
		} catch (SQLException e) {
			Log.e(applicationName, errorString, e);
			return 0;
		}
	}

}
