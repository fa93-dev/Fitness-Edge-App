package com.example.faraz.navigationapp;

import android.os.Bundle;
import android.widget.Toast;


public class WorkoutCountdownActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_workout_countdown);

        if (savedInstanceState == null) {
            WorkoutCountdownFragment fragment = new WorkoutCountdownFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.workout_countdown_container,
                    fragment)
                    .commit();
        } else {
            Toast.makeText(this, "Countdown Activity", Toast.LENGTH_LONG).show();
        }

    }

}
