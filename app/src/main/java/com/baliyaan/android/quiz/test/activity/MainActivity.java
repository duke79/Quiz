package com.baliyaan.android.quiz.test.activity;

import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.baliyaan.android.quiz.test.R;

@ContentView(R.layout.activity_main)
public class MainActivity extends FullScreenActivity {

	@InjectView(R.id.buttonStart)
	private Button buttonStart;

	@InjectView(R.id.buttonMoreGames)
	private Button buttonMoreGames;

	@InjectView(R.id.buttonExit)
	private Button buttonExit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initButtons();
	}

	private void initButtons() {
		initStartGameButton();
		initMoreGamesButton();
		initExitButton();
	}

	private void initExitButton() {
		buttonExit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				createExitDialog().show();
			}
		});
	}

	private void initMoreGamesButton() {
		buttonMoreGames.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
						.parse(getString(R.string.check_more_games_url)));
				startActivity(browserIntent);
			}
		});
	}

	private void initStartGameButton() {
		buttonStart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), LevelsActivity.class);
				startActivity(intent);
			}
		});
	}

	private Dialog createExitDialog() {
		return new AlertDialog.Builder(this).setTitle(getString(R.string.exit_dialog_header))
				.setMessage(getString(R.string.exit_dialog_text))
				.setPositiveButton(getString(R.string.positive_ans), createPositiveAnswerListener())
				.setNegativeButton(getString(R.string.negative_ans), createNegativeAnswerListener()).create();
	}

	private android.content.DialogInterface.OnClickListener createPositiveAnswerListener() {
		return new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// Exit application
				finish();
			}
		};
	}

	private android.content.DialogInterface.OnClickListener createNegativeAnswerListener() {
		return new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// Do nothing
				return;
			}
		};
	}

	@Override
	public void onBackPressed() {
		createExitDialog().show();
	}
}
