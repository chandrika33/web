package com.example.loginpostreq;

import java.util.List;
import java.util.Vector;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void doSignin(View v)
	{
		EditText et1=(EditText)findViewById(R.id.et1);
		EditText et2=(EditText)findViewById(R.id.et2);
		String un=et1.getText().toString();
		String ps=et2.getText().toString();
		new LoginTask().execute(un,ps);
	}
	
	class LoginTask extends AsyncTask<String, String, String>
	{

		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this,result, Toast.LENGTH_LONG).show();
			super.onPostExecute(result);
		}
		
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			try
			{
				HttpClient hc=new DefaultHttpClient();
				HttpPost hpost=new HttpPost("http://192.168.1.4:8080/SAPP/login.jsp");
				
				BasicNameValuePair p1=new BasicNameValuePair("uname",params[0]);
				BasicNameValuePair p2=new BasicNameValuePair("upass",params[1]);
				List<BasicNameValuePair> list=new Vector<BasicNameValuePair>();
				list.add(p1);
				list.add(p2);
				UrlEncodedFormEntity entity=new UrlEncodedFormEntity(list);
				hpost.setEntity(entity);
				HttpResponse hres=hc.execute(hpost);
				Log.d("login",hres.getStatusLine().getStatusCode()+"");
				if(hres.getStatusLine().getStatusCode()==200)
				{
					String res=EntityUtils.toString(hres.getEntity());
					return res;
				}
				
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}
		
	}
}
