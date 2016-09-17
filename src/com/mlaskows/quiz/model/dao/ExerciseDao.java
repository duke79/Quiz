/*
 * Copyright (c) 2013, Maciej Laskowski. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  
 * 
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact mlaskowsk@gmail.com if you need additional information
 * or have any questions.
 */

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

/**
 * Data Access Object for entity {@link Exercise}.
 * 
 * @author Maciej Laskowski
 * 
 */
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
