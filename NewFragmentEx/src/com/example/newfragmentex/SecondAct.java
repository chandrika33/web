package com.example.newfragmentex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;

public class SecondAct extends FragmentActivity {
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.secondview);
		Intent it=getIntent();
		String s=it.getStringExtra("news");
		EditText ed=(EditText)findViewById(R.id.editText1);
		ed.setText(s);
	}

}
