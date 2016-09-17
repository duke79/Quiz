package com.baliyaan.android.quiz.test.activity;

import roboguice.activity.RoboActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

public class FullScreenActivity extends RoboActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}

}
