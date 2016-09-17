package com.baliyaan.android.quiz.test;

import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.annotation.ReportsCrashes;

import android.app.Application;
import android.content.Context;

@ReportsCrashes(formKey = "", mailTo = "pulkitsingh01@gmail.com", customReportContent = { ReportField.ANDROID_VERSION,
		ReportField.BRAND, ReportField.PHONE_MODEL, ReportField.STACK_TRACE, ReportField.LOGCAT }, logcatArguments = {
		"-t", "1000", "-v", "time" })
public class QuizApplication extends Application {

	private static Context context;

	@Override
	public void onCreate() {
		super.onCreate();
		QuizApplication.context = getApplicationContext();
		ACRA.init(this);
	}

	/**
	 * Returns application context.
	 * 
	 * @return application context
	 */
	public static Context getContext() {
		return context;
	}
}
