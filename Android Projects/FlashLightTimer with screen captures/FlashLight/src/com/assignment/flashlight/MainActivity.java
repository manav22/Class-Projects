package com.assignment.flashlight;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.widget.TextView;

import android.view.View;

public class MainActivity extends Activity {
	boolean flashDetector = false;
	
	TextView TimerTextView;
	Camera cameraObj;
	
	MyCount count = new MyCount(30000l, 1000l);
	Camera.Parameters cameraParams;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 TimerTextView = (TextView) this.findViewById(R.id.timer_text_view);
		 
		 cameraObj = Camera.open();
		 cameraParams = cameraObj.getParameters();
			
	}


	
	public void on(View view) {
		if(flashDetector){
			cameraParams.setFlashMode(Parameters.FLASH_MODE_OFF);
			cameraObj.setParameters(cameraParams);
			cameraObj.stopPreview();
			cameraObj.release();
			flashDetector = false;
		}
		else{
			count.start();
		}
	}
		
	public void off(View view) {
		if(flashDetector){
	
			cameraParams.setFlashMode(Parameters.FLASH_MODE_OFF);
			cameraObj.setParameters(cameraParams);
			cameraObj.stopPreview();
			cameraObj.release();
			flashDetector = false;
	
	
		}
	}
		
		
		class MyCount extends CountDownTimer{
			
			 public MyCount(long millisInFuture, long countDownInterval) {
		           super(millisInFuture, countDownInterval);
		   }
			
			@Override
			public void onFinish(){
				TimerTextView.setText("Timer: 0");
				cameraParams.setFlashMode(Parameters.FLASH_MODE_TORCH);
				cameraObj.setParameters(cameraParams);
				cameraObj.startPreview();
				flashDetector = true;
			}
			
			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				TimerTextView.setText("Timer: " + millisUntilFinished/1000);
			}	
		}	
}


