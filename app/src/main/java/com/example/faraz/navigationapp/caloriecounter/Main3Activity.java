
package com.example.faraz.navigationapp.caloriecounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.faraz.navigationapp.R;

public class Main3Activity extends Activity {
	
	private CalorieSummary calSum;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main3);

	}
	
	@Override
	protected void onResume() {
		super.onResume();
		retrieveCalorieLog();
		displayCalorieSummary();
	}

	private void retrieveCalorieLog() {
		LogManager.loadCalorieLog(this);
	}
	
	private void displayCalorieSummary() {
		calSum = new CalorieSummary(LogManager.getLogEntries());
		calSum.display(this);		
	}
	
	/** Listener for open calorie log button **/
	public void openCalorieLog(View view) {
		Intent intent = new Intent(this, DisplayLogActivity.class);
		startActivity(intent);
	}
	
	public void quit(View view) {
		finish();
	}
}
