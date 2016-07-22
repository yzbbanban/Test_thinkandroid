package com.wangban.test_thinkandroid;

import java.util.List;

import com.ta.TAApplication;
import com.ta.util.db.TASQLiteDatabase;

public class UserDao {

	public UserDao(TAApplication app) {
		TASQLiteDatabase tasqLiteDatabase = app.getSQLiteDatabasePool()
				.getSQLiteDatabase();
		if (!tasqLiteDatabase.hasTable(UserEntity.class)) {
			tasqLiteDatabase.creatTable(UserEntity.class);
		}
		app.getSQLiteDatabasePool().releaseSQLiteDatabase(tasqLiteDatabase);
	}

	public void insert(TAApplication taApplication, UserEntity userEntity) {
		TASQLiteDatabase tasqLiteDatabase = taApplication
				.getSQLiteDatabasePool().getSQLiteDatabase();
		tasqLiteDatabase.insert(userEntity);
		taApplication.getSQLiteDatabasePool().releaseSQLiteDatabase(
				tasqLiteDatabase);
	}

	public List<UserEntity> query(TAApplication taApplication,
			UserEntity userEntity) {
		TASQLiteDatabase tasqLiteDatabase = taApplication
				.getSQLiteDatabasePool().getSQLiteDatabase();
		List<UserEntity> userEntities = tasqLiteDatabase.query(
				UserEntity.class, true, null, null, null, null, null);
		taApplication.getSQLiteDatabasePool().releaseSQLiteDatabase(
				tasqLiteDatabase);
		return userEntities;
	}
}
