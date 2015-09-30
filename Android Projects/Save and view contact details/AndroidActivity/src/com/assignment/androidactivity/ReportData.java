package com.assignment.androidactivity;
/*
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ReportData extends Activity {
	
	ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report_data);
		
		list = (ListView) findViewById(R.id.list);
		
		List<UserData> userDataList = new MySQLiteHelper(this).getAllUserData();
		
		List<String> nameList = new ArrayList<String>();
		
		for(int i = 0; i < userDataList.size(); i++) {
			nameList.add(userDataList.get(i).getFirstName());
		}
		
		list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameList));

		
	}
}*/
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
public class ReportData extends Activity {
	String TAG = "ReportData";
    ListView list;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_data);
        list = (ListView)findViewById(R.id.list);
        
        List<UserData> userDataList = new MySQLiteHelper(this).getAllUserData();
        
        if(userDataList != null && userDataList.size() > 0) {
        	list.setAdapter(new CustomAdapter(this, userDataList));
        }
    }
}