package com.baliyaan.android.quiz.test.utility;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class ImageUtility {

	/**
	 * Private constructor to avoid instantiating.
	 */
	private ImageUtility() {
		;
	}

	/**
	 * Static method for resizing {@link Drawable} objects.
	 * 
	 * @param drawable
	 *            object to resize
	 * @param width
	 *            new object width
	 * @param height
	 *            new object height
	 * @return resized {@link Drawable}
	 */
	@SuppressWarnings("deprecation")
	public static Drawable resizeDrawable(Drawable drawable, int width, int height) {
		if ((drawable == null) || !(drawable instanceof BitmapDrawable)) {
			return drawable;
		}
		Bitmap b = ((BitmapDrawable) drawable).getBitmap();
		Bitmap bitmapResized = Bitmap.createScaledBitmap(b, width, height, false);
		return new BitmapDrawable(bitmapResized);
	}

	/**
	 * Static method for resizing {@link Drawable} objects.
	 * 
	 * @param drawable
	 *            object to resize
	 * @param scaleFactor
	 *            scale factor
	 * @return resized {@link Drawable}
	 */
	public static Drawable resizeDrawable(Drawable drawable, float scaleFactor) {
		int width = Math.round(drawable.getIntrinsicWidth() * scaleFactor);
		int height = Math.round(drawable.getIntrinsicHeight() * scaleFactor);
		return resizeDrawable(drawable, width, height);
	}

}
