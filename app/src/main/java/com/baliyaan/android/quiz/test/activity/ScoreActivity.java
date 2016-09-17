package com.baliyaan.android.quiz.test.activity;

import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.inject.Inject;
import com.baliyaan.android.quiz.test.R;
import com.baliyaan.android.quiz.test.activity.clicklistener.LevelResetListener;
import com.baliyaan.android.quiz.test.model.dao.LevelDao;
import com.baliyaan.android.quiz.test.model.entity.Level;

@ContentView(R.layout.activity_score)
public class ScoreActivity extends FullScreenActivity {

	@InjectView(R.id.buttonReset)
	private Button levelResetButton;

	@Inject
	private LevelDao levelDao;

	private Level level;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = getIntent().getExtras();
		setLevel(bundle.getInt(getString(R.string.level_id)));
		setScoreOnTextView(bundle.getInt(getString(R.string.score)));
		initButtons();
	}

	private void setLevel(Integer levelId) {
		level = levelDao.queryForId(levelId);
	}

	private void setScoreOnTextView(int score) {
		TextView tv = (TextView) findViewById(R.id.scoreText);
		tv.setText(tv.getText() + "\n" + score);
	}

	private void initButtons() {
		levelResetButton.setOnClickListener(new LevelResetListener(this, level));
	}

	@Override
	public void onBackPressed() {
		Intent intent = new Intent(getApplicationContext(), LevelsActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}


}
