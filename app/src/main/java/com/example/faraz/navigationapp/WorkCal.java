package com.example.faraz.navigationapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Faraz on 07-04-2017.
 */


public class WorkCal extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.crunch.MESSAGE";
    HashMap<String, Double> conversions = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.work_cal);

        //Spinner code from android.com
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(this, R.array.exercise_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        //Add conversions to HashMap
        conversions.put("Pushup", 100.0/350.0);
        conversions.put("Situp", 100.0/200.0);
        conversions.put("Squats", 100.0/225.0);
        conversions.put("Leg", 100.0/25.0);
        conversions.put("Plank", 100.0/25.0);
        conversions.put("Jumping", 100.0/10.0);
        conversions.put("Pullup", 100.0/100.0);
        conversions.put("Cycling", 100.0/12.0);
        conversions.put("Walking", 100.0/20.0);
        conversions.put("Jogging", 100.0/12.0);
        conversions.put("Swimming", 100.0/13.0);
        conversions.put("Stair", 100.0/15.0);
        conversions.put("Calorie", 1.0);
    }


    /** Called when the user clicks the Send button */
    public void calculate(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String count = editText.getText().toString();
        double countDouble = Double.parseDouble(count);
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        String exercise = spinner.getSelectedItem().toString();
        exercise = exercise.split("\\W+")[0];
        double calories = countDouble * conversions.get(exercise);
        double caloriesRounded = Math.round(calories * 10) / 10d;

        TextView caloriesBurned = (TextView)findViewById(R.id.caloriesBurned);
        caloriesBurned.setText(String.valueOf(caloriesRounded));
        for(String ex : conversions.keySet()) {
            if (ex == "Calorie") {
                continue;
            }
            ex = ex.split("\\W+")[0];
            String exerciseIDString = ex + "Count";
            int exerciseID = getResources().getIdentifier(exerciseIDString, "id", getPackageName());
            TextView exerciseCount = (TextView)findViewById(exerciseID);
            double exCount = calories / conversions.get(ex);
            exCount = Math.round(exCount * 10) / 10d;
            exerciseCount.setText(String.valueOf(exCount));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}