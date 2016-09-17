package com.baliyaan.android.quiz.test.model;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Locale;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.content.Context;
import android.content.res.Resources;

import com.baliyaan.android.quiz.test.R;
import com.baliyaan.android.quiz.test.model.entity.Quiz;

public class XmlDataLoader {

		/** Application context. */
	private Context context;
	
	public XmlDataLoader(Context context) {
		this.context = context;
	}

	/**
	 * Loads XML with quiz and returns {@link Quiz} object.
	 * 
	 * @return quiz object
	 * @throws Exception
	 *             when deserialization fails
	 */
	public Quiz loadXml() throws Exception {
		Resources resources = context.getResources();
		String languageCode = getLanguageCode(resources);
		// Get XML name using reflection
		Field field = null;
		String prefix = context.getString(R.string.xml_prefix);
		try {
			field = R.raw.class.getField(prefix + languageCode);
		} catch (NoSuchFieldException e) {
			// If there is no language available use default
			field = R.raw.class.getField(prefix + context.getString(R.string.default_language));
		}
		// Create InputSream from XML resource
		InputStream source = resources.openRawResource(field.getInt(null));
		// Parse XML
		Serializer serializer = new Persister();
		return serializer.read(Quiz.class, source);
	}

	private String getLanguageCode(Resources resources) {
		Locale locale = resources.getConfiguration().locale;
		String code = locale.getLanguage();
		return code;
	}
	
}
