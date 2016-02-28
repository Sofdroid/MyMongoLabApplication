package com.example.mortadha.mymongolabapplication.MongoLab.MongoLab;

import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;



public class MainActivity extends Activity {
	EditText editText_last_name;
	EditText editText_phone;
	EditText editText_email;
	EditText editText_fname;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editText_fname = (EditText) findViewById(R.id.editText_fname);
		editText_last_name = (EditText) findViewById(R.id.editText_last_name);
		editText_email = (EditText) findViewById(R.id.editText_email);
		editText_phone = (EditText) findViewById(R.id.editText_phone);

	}

	public void saveContact(View v) throws UnknownHostException {
		MyContact contact = new MyContact();
		contact.first_name = editText_fname.getText().toString();
		contact.last_name = editText_last_name.getText().toString();
		contact.email = editText_email.getText().toString();
		contact.phone = editText_phone.getText().toString();
		SaveAsyncTask tsk = new SaveAsyncTask();
		tsk.execute(contact);
	}
	public void showList(View view) throws UnknownHostException{
		Intent i = new Intent(this, ViewContactsActivity.class);
		startActivity(i);
	}

}
