package com.assignment.androidactivity;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	static final String FIRST_NAME_KEY = "FIRST_NAME_KEY";
	static final String LAST_NAME_KEY = "LAST_NAME_KEY";
	static final String ADDRESS_KEY = "ADDRESS";
	static final String CREDIT_CARD_KEY = "CREDIT_CARD_KEY";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    final	EditText FirstName = (EditText) findViewById(R.id.first_name);
		final	EditText LastName = (EditText) findViewById(R.id.last_name);
		final	EditText Address = (EditText) findViewById(R.id.address);
		final	EditText CreditCard = (EditText) findViewById(R.id.credit_card);
		
		
		Button ReportData = (Button) findViewById(R.id.report_data);
		Button ProcessData = (Button) findViewById(R.id.process_data);
		Button SaveData = (Button) findViewById(R.id.save_data);
		Button Close = (Button) findViewById(R.id.close);
		
		
		ProcessData.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				
				Intent intent = new Intent(MainActivity.this, ProcessData.class);
				intent.putExtra(FIRST_NAME_KEY, FirstName.getText().toString());
				intent.putExtra(LAST_NAME_KEY, LastName.getText().toString());
				intent.putExtra(ADDRESS_KEY, Address.getText().toString());
				intent.putExtra(CREDIT_CARD_KEY, CreditCard.getText().toString());
				startActivity(intent);
			}
		});
		
		SaveData.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){

				Intent intent = new Intent(MainActivity.this, SaveData.class);
				intent.putExtra(FIRST_NAME_KEY, FirstName.getText().toString());
				intent.putExtra(LAST_NAME_KEY, LastName.getText().toString());
				intent.putExtra(ADDRESS_KEY, Address.getText().toString());
				intent.putExtra(CREDIT_CARD_KEY, CreditCard.getText().toString());
				startActivity(intent);
				
				
			}
		});
		
		ReportData.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent(MainActivity.this, ReportData.class);
				startActivity(intent);
				
			}
		});
		
		Close.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
			
			finish();	
				
			}
		});
		
	
	}

}
