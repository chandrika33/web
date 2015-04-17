package com.example.newfragmentex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	public void call(View v)
	{
	Fragment f=getSupportFragmentManager().findFragmentById(R.id.f2);
	if(f==null)
	{
		Intent it=new Intent(this,SecondAct.class);
		it.putExtra("news","latest");
		startActivity(it);
	}
	else
	{
		EditText e=(EditText)findViewById(R.id.editText1);
		e.setText("latest");
	}
			
		
	}
}
