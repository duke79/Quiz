package com.baliyaan.android.quiz.test.activity.clicklistener;

import roboguice.RoboGuice;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.google.inject.Inject;
import com.baliyaan.android.quiz.test.R;
import com.baliyaan.android.quiz.test.activity.ExerciseActivity;
import com.baliyaan.android.quiz.test.activity.ScoreActivity;
import com.baliyaan.android.quiz.test.activity.util.ActivityStarter;
import com.baliyaan.android.quiz.test.activity.util.BundleBuilder;
import com.baliyaan.android.quiz.test.model.dao.ExerciseDao;
import com.baliyaan.android.quiz.test.model.dao.LevelDao;
import com.baliyaan.android.quiz.test.model.entity.Exercise;
import com.baliyaan.android.quiz.test.model.entity.Level;

public class LevelResetListener implements OnClickListener {

	private ScoreActivity scoreActivity;

	private Level level;

	@Inject
	private ExerciseDao exerciseDao;

	@Inject
	private LevelDao levelDao;

	public LevelResetListener(ScoreActivity scoreActivity, Level level) {
		RoboGuice.injectMembers(scoreActivity.getApplicationContext(), this);
		this.scoreActivity = scoreActivity;
		this.level = level;
	}

	@Override
	public void onClick(View v) {
		cleanLevel();
		startNewActivity();
	}

	private void cleanLevel() {
		level.setScore(0);
		for (Exercise exercise : level.getExercises()) {
			exercise.setTipUsed(false);
			exercise.setSolved(false);
			exerciseDao.update(exercise);
		}
		levelDao.update(level);
	}

	private void startNewActivity() {
		Bundle bundle = new BundleBuilder().withInteger(scoreActivity.getString(R.string.level_id), level.getId())
				.build();
		ActivityStarter.start(scoreActivity, bundle, ExerciseActivity.class);
	}
}