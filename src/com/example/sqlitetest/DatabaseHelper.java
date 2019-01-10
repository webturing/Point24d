package com.example.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	// ��ȫ�������Ĺ��캯�����˹��캯���ز�����
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// �������ݿ�sql��� �� ִ�� �������[1,2,3,4]  1*2*3*4
		String sql = "create table tb2(numbers varchar(20),solution varchar(50))";
		Log.i("DB", "���ݱ����ɹ�");
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
}