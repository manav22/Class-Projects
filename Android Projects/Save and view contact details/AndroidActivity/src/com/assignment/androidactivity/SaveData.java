package com.assignment.androidactivity;

import java.io.File;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class SaveData extends Activity{
	

	
	
	public static final String tracker = "SaveData";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.save_data);


		Button SqLite = (Button) findViewById(R.id.sqlite);
		Button SharedPreferences = (Button) findViewById(R.id.shared_preferences);
		
		
		
		//db.execSQL("CREATE TABLE IF NOT EXISTS UserData(FirstName VARCHAR, LastName VARCHAR, Address VARCHAR, CreditCard VARCHAR);");
		
		
	
		
		// Get data via the key
		Log.e(tracker,"m here");
		

		Bundle extras = getIntent().getExtras();
		if (extras == null) {
		    return;
		    }
		
		final String firstName = extras.getString(MainActivity.FIRST_NAME_KEY);
		final String lastName =  extras.getString(MainActivity.LAST_NAME_KEY);
		final String address =  extras.getString(MainActivity.ADDRESS_KEY);
		final String creditCard =  extras.getString(MainActivity.CREDIT_CARD_KEY);
		
		final UserData userdata = new UserData();
		
		userdata.setFirstName(firstName);
		userdata.setLastName(lastName);
		userdata.setAddress(address);
		userdata.setCreditCardNUmber(creditCard);
		
		final MySQLiteHelper db = new MySQLiteHelper(this);
		
		
		//if (value1 != null) {
		  // do something with the data
		//} 
		SqLite.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
		//db.open();
				
				
				
				
				Log.e(tracker,"m here --> " + userdata.toString());
				
				
				db.addUserData(userdata);
				db.getAllUserData();
				
				
				
				
			
			}
		});
		
		SharedPreferences.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				
				
			}
		});
		
	}

}
