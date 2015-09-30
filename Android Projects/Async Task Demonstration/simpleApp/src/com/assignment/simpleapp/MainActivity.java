package com.assignment.simpleapp;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.util.ByteArrayBuffer;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.os.AsyncTask;

public class MainActivity extends Activity {
	private boolean pageLoaded = false;
	static final String TAG = "MainActivity";
	private TextView companySymbol;
	private TextView sharePrice;
	private TextView percentageChange;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	 
		final String url = "http://www.sjsu.edu";
		
	 final WebView view = (WebView) this.findViewById(R.id.webView1);
	 view.setWebViewClient(new MyWebViewClient());
		Button loadUrlBtn = (Button) findViewById(R.id.load_url_btn);
		Button submitAssignmentBtn = (Button) findViewById(R.id.submit_assignment_btn);
		Button stockValueBtn = (Button) findViewById(R.id.stock_value_btn);
		
		companySymbol = (TextView) findViewById(R.id.company_symbol);
		sharePrice = (TextView) findViewById(R.id.share_price);
		percentageChange = (TextView) findViewById(R.id.percent_change);
		
		//submitAssignmentButton
		loadUrlBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				
				
				view.loadUrl(url);		
			}
		});
		
		submitAssignmentBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
				if(pageLoaded==true) {
					
					AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
					builder.setTitle("Congrats");
					builder.setMessage("Assignment Completed");
					builder.setPositiveButton("Ok", null);
					builder.show();
				}
				else {
					
					AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
					builder.setTitle("Sorry!");
					builder.setMessage("Please click on the other button first to complete the assignment");
					builder.setPositiveButton("Ok", null);
					builder.show();
				}
				
			}
		});
		
		stockValueBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				  new AsyncCaller().execute();
			}
	
		});
	}
	
	
	class MyWebViewClient extends WebViewClient {
		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
			pageLoaded = false;
		}
		
		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			pageLoaded = true;
		}
		
		@Override
		public void onReceivedError(WebView view, int errorCode,
				String description, String failingUrl) {
			super.onReceivedError(view, errorCode, description, failingUrl);
			pageLoaded = false;
		}
	}
	
	class AsyncCaller extends AsyncTask<Void, Void, Stock>
	{

	    @Override
	    protected void onPreExecute() {
	        super.onPreExecute();

	        //this method will be running on UI thread
	        
	    }
	    @Override
	    protected Stock doInBackground(Void... params) {
	    	Log.e(TAG, "Inside bg");

	        //this method will be running on background thread so don't update UI frome here
	        //do your long running http tasks here,you dont want to pass argument and u can access the parent class' variable url over here

			URL url;
			try {
				url= new URL("http://download.finance.yahoo.com/d/quotes.csv?s=goog&f=sl1p2");
				InputStream stream = url.openStream();
				BufferedInputStream bis = new BufferedInputStream(stream);
				ByteArrayBuffer baf = new ByteArrayBuffer(200);
				
				int current = 0;
				while((current = bis.read())!=-1){
					baf.append((byte)current);
				}
				
				String stockTxt = new String(baf.toByteArray());
				String[] tokens = stockTxt.split(",");
				
				for(int i = 0; i < tokens.length; i++) {
					Log.e(TAG, "Response --> " + tokens[i]);
				}
				
				Stock stock = new Stock(tokens[0], tokens[1], tokens[2]);
				
				String symbolOut1 = tokens[0];
				String priceOut1 = tokens[1];
				String changePercentage1 = tokens[2];
				
				String fsymbolOut = symbolOut1.substring(1, symbolOut1.length() -1);
				String fchangePercentage = changePercentage1.substring(1, changePercentage1.length() -3);
				return stock;
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	        return null;
	    }

	    @Override
	    protected void onPostExecute(Stock result) {
	        super.onPostExecute(result);
	        if(result != null) {
	        	companySymbol.setText(result.getOrganizationName());
	        	percentageChange.setText(result.getPercentchange());
	        	sharePrice.setText(result.getCurrentValue());
	        }

	    }

	}
	
	class Stock {
		private String organizationName;
		private String currentValue;
		private String percentChange;
		
		
		public Stock(String organizationName, String currentValue,
				String changeinPercent) {
			
			this.organizationName = organizationName;
			this.currentValue = currentValue;
			this.percentChange = changeinPercent;
		}
		public String getOrganizationName() {
			return organizationName;
		}
		public void setOrganizationName(String organizationName) {
			this.organizationName = organizationName;
		}
		public String getCurrentValue() {
			return currentValue;
		}
		public void setCurrentValue(String currentValue) {
			this.currentValue = currentValue;
		}
		public String getPercentchange() {
			return percentChange;
		}
		public void setPercentChange(String changeinPercent) {
			this.percentChange = changeinPercent;
		}
	}
}



	
