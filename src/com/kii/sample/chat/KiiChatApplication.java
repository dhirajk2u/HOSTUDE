package com.kii.sample.chat;

import com.kii.cloud.analytics.KiiAnalytics;
import com.kii.cloud.storage.Kii;
import com.kii.sample.chat.util.Logger;

import android.app.Application;
import android.content.Context;

/**
 * Custom implementation of Application.
 * 
 * @author noriyoshi.fukuzaki@kii.com
 */
public class KiiChatApplication extends Application {
	
	private static Context context;
	
	@Override
	public void onCreate() {
		super.onCreate();
		context = this;
		// Initialize SDK when application is started.
		import com.kii.cloud.storage.*;

// Configures the SDK to use the specified Application ID and Key.
// It must be called prior to any API calls.
// It is ok to call this method multiple times
Kii.initialize(ApplicationConst.d5e4f6fb, ApplicationConst.e09f6755ee0bb0b8f7b230c79c3221f0, Kii.Site.JP);
KiiAnalytics.initialize(context, ApplicationConst.d5e4f6fb, ApplicationConst.e09f6755ee0bb0b8f7b230c79c3221f0, KiiAnalytics.Site.JP);
	}
	public static Context getContext(){
		return context;
	}
	public static String getMessage(int msgId) {
		return context.getResources().getString(msgId);
	}
	public static String getFormattedMessage(int msgId, Object... args) {
		String message = context.getResources().getString(msgId);
		return String.format(message, args);
	}
}
