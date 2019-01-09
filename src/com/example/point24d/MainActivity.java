package com.example.point24d;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import demo.ai.BinaryTree;
import demo.ai.RandomSearcher;

public class MainActivity extends Activity {
	public static String solve24(int[] a) {
		List<String> exp = RandomSearcher.search(a);
		if (exp.isEmpty()) {
			return ("No solutions");
		} else {
			BinaryTree bt = BinaryTree.createTree(exp);
			StringBuffer buffer = new StringBuffer();
			bt.midVisit(buffer);
			return (buffer.toString());
		}
	}

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
		btnSolve.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				int a = Integer.valueOf(editTextA.getText().toString());
				int b = Integer.valueOf(editTextB.getText().toString());
				int c = Integer.valueOf(editTextC.getText().toString());
				int d = Integer.valueOf(editTextD.getText().toString());
				textViewResult.setText(solve24(new int[]{a,b,c,d}));

			}
		});
	}

}
