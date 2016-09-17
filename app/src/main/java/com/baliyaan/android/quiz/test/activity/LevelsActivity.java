package com.baliyaan.android.quiz.test.activity;

import java.util.List;

import roboguice.inject.ContentView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.google.inject.Inject;
import com.baliyaan.android.quiz.test.R;
import com.baliyaan.android.quiz.test.adapter.LevelsAdapter;
import com.baliyaan.android.quiz.test.model.dao.LevelDao;
import com.baliyaan.android.quiz.test.model.entity.Level;

@ContentView(R.layout.activity_levels)
public class LevelsActivity extends FullScreenActivity {

	@Inject
	private LevelDao levelDao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setUpAdapter();
	}

	private void setUpAdapter() {
		List<Level> levels = levelDao.queryForAll();
		LevelsAdapter adapter = new LevelsAdapter(this, R.layout.list_item_row, levels);
		ListView listView = (ListView) findViewById(R.id.listLevels);
		listView.setAdapter(adapter);
	}

	@Override
	public void onBackPressed() {
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}
}
