package com.wangban.test_thinkandroid;

import java.util.ArrayList;
import java.util.List;

import com.ta.TAApplication;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private TAApplication app;
	List<UserEntity> userEntities;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setData();
	}

	private void setData() {
		app = (TAApplication) getApplication();
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername("ban");
		userEntity.setPassword("ban");

		UserDao userDao = new UserDao(app);
		userDao.insert(app, userEntity);

		userEntity.setUsername("b");
		userEntity.setPassword("an");
		userDao.insert(app, userEntity);
		userEntity.setUsername("b");
		userEntity.setPassword("an");
		userDao.insert(app, userEntity);
		userEntity.setUsername("b");
		userEntity.setPassword("an");
		userDao.insert(app, userEntity);

		// List<UserEntity> userEntities = userDao.query(app, userEntity);
		userEntities = new ArrayList<UserEntity>(userDao.query(app, userEntity));

		Log.i("supergirl", "userEntities: " + userEntities.size());
	}

}
