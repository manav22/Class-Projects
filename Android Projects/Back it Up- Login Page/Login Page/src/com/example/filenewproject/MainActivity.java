package com.example.filenewproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
   public EditText  username=null;
   public EditText  password=null;
   private TextView attempts;
   private Button login;
   public String usrnm, psswd;
   public String usrnmLogged, psswdLogged;
   boolean resultMatch= false;;
   boolean loggedIn= false;
   int counter = 3;
   DataBaseConnection dbc;
   Connection connLogin;   
   Statement stmt;
   SharedPreferences sh_Pref;
   private static final String MY_PREFERENCES = "Login Credentials";  
   Editor toEdit;
    
    boolean flag_on_Create = false;
    boolean flag_on_Resume = false;
    boolean flag_on_Start = false;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      
      attempts = (TextView)findViewById(R.id.textView5);
      //attempts.setText(Integer.toString(counter));
      login = (Button)findViewById(R.id.button1);
      sh_Pref = getSharedPreferences(MY_PREFERENCES, MODE_PRIVATE); 
      boolean secondCreate;
      secondCreate = sh_Pref.getBoolean("first", loggedIn);
      if (secondCreate == true)
      {
    	  flag_on_Create = true;
    	  Intent intent = new Intent(getApplicationContext(), Second.class);
    	  startActivity(intent);
      }
   }
   
   @Override
   protected void onResume(){
	   super.onResume();
	   if( flag_on_Create == false && flag_on_Start == false)
	   {
		   boolean secondResume;
		   secondResume = sh_Pref.getBoolean("first", loggedIn);
	       
	    if (secondResume == true )
	      {
	    	flag_on_Resume = true;
	    	  Intent intent = new Intent(getApplicationContext(), Second.class);
	    	  startActivity(intent);
	      }
	   }
   }
   @Override
   protected void onStart(){
	   super.onStart();
	   if(flag_on_Create == false)
	   {
		   flag_on_Start = true;
	   boolean secondStart;
	      secondStart = sh_Pref.getBoolean("first", loggedIn);
	      
	   if (secondStart == true )
	      {
	    	  Intent intent = new Intent(getApplicationContext(), Second.class);
	    	  startActivity(intent);
	      }
	   }
	   }
   
   public void login(View view){
	   
	   username = (EditText)findViewById(R.id.editText1);
       password = (EditText)findViewById(R.id.editText2);  	
 	  usrnm = username.getText().toString();
 	  psswd = password.getText().toString();
	   new ConnectToDatabaseTask().execute();
   }


   	 public void logged()
   		{
   			loggedIn= true;
   			Toast.makeText(getApplicationContext(), "Redirecting...", 
		      Toast.LENGTH_SHORT).show();
   			sharedPrefernces();
   		}
     
   	 public void sharedPrefernces() 
      	{ 
		sh_Pref = getSharedPreferences(MY_PREFERENCES, MODE_PRIVATE); 
		toEdit = sh_Pref.edit(); 
		toEdit.putString("usrnmLogged", usrnmLogged); 
		toEdit.putString("psswdLogged", psswdLogged); 
		toEdit.putBoolean("first",loggedIn);
		toEdit.commit(); 
		
		}
   
      public void notLogged()
  		{
	   
		      Toast.makeText(getApplicationContext(), "Wrong Credentials",
		      Toast.LENGTH_SHORT).show();
		      attempts.setBackgroundColor(Color.RED);	
		      counter--;
		      attempts.setText(Integer.toString(counter));
		      if(counter==0){
		         login.setEnabled(false);
	      }

   }
   
      @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
   }
   
      class ConnectToDatabaseTask extends AsyncTask<Void, Void, Void> {
		
	      @Override
	     protected void onPostExecute(Void result) {
	    	 		if (resultMatch == true)  	 			
	    	 			logged();
	    	 		else
	    	 			notLogged();
	     
	      }

		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
		
				dbc = new DataBaseConnection();
				
			   connLogin = dbc.getDataBaseConnection();
			   
				 		
		 		if(usrnm != null && psswd != null){
		 			 String query = "select * from USER where USERNAME= '"+usrnm+"' AND PASSWORD= '"+psswd+"'";
		 			try {
		 					if(connLogin != null){
		 						stmt = connLogin.createStatement();
		 						stmt.executeQuery(query);
		 						ResultSet rs = stmt.executeQuery(query);
		 						
		 						if (rs.next()){
		 							usrnmLogged = rs.getString("USERNAME");
		 							psswdLogged = rs.getString("PASSWORD");
		 							resultMatch = true;
		 						}		
		 					}
		 			}
		 						catch (Exception e) {
		 		 					System.out.println("Error in execute query::"+e.getMessage());
		 		 					e.printStackTrace();
		 		 			}	}		 
			return null;
		}
   		}
   }