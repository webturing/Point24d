package com.example.point24d;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnExit=(Button) super.findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				System.exit(0);
				
			}
		});
    }

}
