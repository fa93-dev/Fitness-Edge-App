package com.example.faraz.navigationapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PedometerActivity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = PedometerActivity.class.getSimpleName();

    // Layout components
    @BindView(R.id.stepsText) TextView mStepsText;
    @BindView(R.id.detectorTypeText) TextView mDetectorTypeText;
    @BindView(R.id.statsButton) Button mStatsButton;

    // Variables
    private SensorManager mSensorManager;
    private Sensor mStepCounterSensor;
    private Sensor mStepDetectorSensor;
    private LinearLayout linearLayout;
    private int mNumSteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_pedometer);
        ButterKnife.bind(this);

        PackageManager packageManager = getPackageManager();
        if (!packageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_STEP_COUNTER)) {
            Toast.makeText(getApplicationContext(), "Sorry, Your Device is not supported", Toast.LENGTH_LONG).show();

        }

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mStepCounterSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        mStepDetectorSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

        mStatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PedometerActivity.this, StatsActivity.class);
                intent.putExtra("numSteps", mNumSteps);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        float[] values = sensorEvent.values;

        if (values.length > 0) {
            mNumSteps = (int) values[0];
        }

        Log.d(TAG, "mNumSteps: " + mNumSteps);

        mStepsText.setText(String.valueOf(mNumSteps));

        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            mDetectorTypeText.setText("Steps detected by the Step Counter");
        } else if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            mDetectorTypeText.setText("Steps detected by the Step Detector");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override
    protected void onResume() {
        super.onResume();

        mSensorManager.registerListener(this, mStepCounterSensor, SensorManager.SENSOR_DELAY_FASTEST);
        mSensorManager.registerListener(this, mStepDetectorSensor, SensorManager.SENSOR_DELAY_FASTEST);
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
