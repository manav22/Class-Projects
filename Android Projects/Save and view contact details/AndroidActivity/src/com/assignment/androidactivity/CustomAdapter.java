package com.assignment.androidactivity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<List<UserData>> {
	private final Activity context;
	private List<UserData> userDataList = new ArrayList<UserData>();

	List<String> user = new ArrayList<String>();

	public CustomAdapter(Activity context, List<UserData> userDataList) {
		super(context, R.layout.list_single);
		this.context = context;
		this.userDataList = userDataList;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		Log.e("Adapter", "Creating views");
		if(view == null) {
			LayoutInflater inflater = context.getLayoutInflater();
			view = inflater.inflate(R.layout.list_single, null);
		}
		
		TextView FirstName = (TextView) view.findViewById(R.id.first_name);
		TextView LastName = (TextView) view.findViewById(R.id.last_name);
		TextView Address = (TextView) view.findViewById(R.id.address);
		TextView CreditCard = (TextView) view.findViewById(R.id.credit_card);
		
		UserData userData = userDataList.get(position);
		if(userData != null) {
			FirstName.setText("First Name: " + userData.getFirstName());
			LastName.setText("Last Name: " + userData.getLastName());
			Address.setText("Address: " + userData.getAddress());
			CreditCard.setText("Credit Card: " + userData.getCreditCardNUmber());
		}
		return view;
	}
	
	@Override
	public int getCount() {
		return userDataList.size();
	}
}