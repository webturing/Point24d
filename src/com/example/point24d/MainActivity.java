package com.example.point24d;

import java.util.Arrays;
import com.example.sqlitetest.DatabaseHelper;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import demo.ai.Point24;
import demo.ai.RandomSearcher;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btnExit = (Button) super.findViewById(R.id.btnExit);
		Button btnSolve = (Button) super.findViewById(R.id.btnSolve);
		final EditText editTextA = (EditText) super
				.findViewById(R.id.editTextA);
		final EditText editTextB = (EditText) super
				.findViewById(R.id.editTextB);
		final EditText editTextC = (EditText) super
				.findViewById(R.id.editTextC);
		final EditText editTextD = (EditText) super
				.findViewById(R.id.editTextD);
		final TextView textViewResult = (TextView) super
				.findViewById(R.id.textViewResult);
		btnExit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				System.exit(0);
			}
		});
		DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this,
				"test_db", null, 1);
		Log.i("DB", "数据库创建成功");
		final SQLiteDatabase db = dbHelper.getWritableDatabase();
		btnSolve.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				int a = Integer.valueOf(editTextA.getText().toString());
				int b = Integer.valueOf(editTextB.getText().toString());
				int c = Integer.valueOf(editTextC.getText().toString());
				int d = Integer.valueOf(editTextD.getText().toString());
				int[] arr = new int[] { a, b, c, d };
				Arrays.sort(arr);
				String keys = Arrays.toString(arr);
				// TO 先查询数据库的结果 如果存在直接读取结果
				Log.i("DB", "start querying1!");
				Cursor cursor = db.query("tb2", new String[] { "numbers",
						"solution" }, null, null, null, null, null);
				boolean find = false;
				Log.i("DB", "start querying2!");
				while (cursor.moveToNext()) {
					String numbers = cursor.getString(cursor
							.getColumnIndex("numbers"));
					if (numbers.equals(keys)) {
						String solution = cursor.getString(cursor
								.getColumnIndex("solution"));
						textViewResult.setText(solution);
						Toast.makeText(MainActivity.this,"读取本地数据库记录",Toast.LENGTH_SHORT).show();
						Log.i("DB", "query succesfully!");
						find = true;
						break;
					}
				}
				// 否则计算后存入数据库
				if (!find) {
					String answer = Point24.solve(arr);
					textViewResult.setText(answer);			
					ContentValues values = new ContentValues();
					Log.i("DB", "start inserting!");
					values.put("numbers", keys);
					values.put("solution", answer);

					// 数据库执行插入命令
					db.insert("tb2", null, values);
					Log.i("DB", "insert succesfully!");
					Toast.makeText(MainActivity.this,"插入数据库成功",Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
