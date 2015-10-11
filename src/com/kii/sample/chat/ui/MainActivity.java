package com.kii.sample.chat.ui;

import com.kii.cloud.storage.KiiUser;
import com.kii.cloud.storage.callback.KiiUserCallBack;
import com.kii.sample.chat.PreferencesManager;
import com.kii.sample.chat.model.ChatRoom;
import com.kii.sample.chat.ui.util.SimpleProgressDialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;

/**
 * Main activity.
 * This activity does not have UI.
 * 
 * @author noriyoshi.fukuzaki@kii.com
 */
String token = PreferencesManager.getStoredAccessToken();
if (!TextUtils.isEmpty(token)) {
  KiiUser.loginWithToken(new KiiUserCallBack() {
    @Override
    public void onLoginCompleted(int token, KiiUser user, Exception e) {
        if (e == null) {
          ChatRoom.ensureSubscribedBucket(user);
          Intent intent = new Intent(MainActivity.this, ChatMainActivity.class);
          intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
          startActivity(intent);
        } else {
          PreferencesManager.setStoredAccessToken("");
          Intent intent = new Intent(MainActivity.this, SigninActivity.class);
          intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
          startActivity(intent);
       
    }
  },token);
} else {
  Intent intent = new Intent(MainActivity.this, SigninActivity.class);
  intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
  startActivity(intent);
}
					} else {
						PreferencesManager.setStoredAccessToken("");
						Intent intent = new Intent(MainActivity.this, SigninActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(intent);
					}
					SimpleProgressDialogFragment.hide(getSupportFragmentManager());
				}
			},token);
		} else {
			Intent intent = new Intent(MainActivity.this, SigninActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
	}
}
