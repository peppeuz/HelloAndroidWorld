package com.example.helloandroidworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class SecondActivity extends Activity {
	Button createToast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		createToast = (Button) findViewById(R.id.buttonToast);
		createToast.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast toastExample;
				toastExample = Toast.makeText(getApplicationContext(),  getResources().getString(R.string.toast), Toast.LENGTH_LONG);
				toastExample.show();
                              
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	
}
