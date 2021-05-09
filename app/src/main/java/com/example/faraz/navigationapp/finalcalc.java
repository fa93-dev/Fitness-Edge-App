package com.example.faraz.navigationapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.faraz.navigationapp.HealthCalc.Bmi;
import com.example.faraz.navigationapp.HealthCalc.Bmr;
import com.example.faraz.navigationapp.HealthCalc.CalcIntake;
import com.example.faraz.navigationapp.HealthCalc.MacroNutri;
import com.example.faraz.navigationapp.HealthCalc.femFat;
import com.example.faraz.navigationapp.HealthCalc.maleFat;

public class finalcalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalcalc);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

}
    public void fact1(View v) {

        Intent i1 = new Intent(finalcalc.this, Bmi.class);
        ActivityOptions options = ActivityOptions.makeScaleUpAnimation(v, 0,
                0, v.getWidth(), v.getHeight());
        startActivity(i1,options.toBundle());
    }

    public void fact2(View v) {

        Intent i2 = new Intent(finalcalc.this, Bmr.class);
        ActivityOptions options = ActivityOptions.makeScaleUpAnimation(v, 0,
                0, v.getWidth(), v.getHeight());
        startActivity(i2,options.toBundle());
    }
    public void fact3(View v) {

        Intent i3 = new Intent(finalcalc.this, MacroNutri.class);
        ActivityOptions options = ActivityOptions.makeScaleUpAnimation(v, 0,
                0, v.getWidth(), v.getHeight());
        startActivity(i3,options.toBundle());
    }
    public void fact4(View v) {

        Intent i4 = new Intent(finalcalc.this, CalcIntake.class);
        ActivityOptions options = ActivityOptions.makeScaleUpAnimation(v, 0,
                0, v.getWidth(), v.getHeight());
        startActivity(i4,options.toBundle());
    }
    public void malefat(View v) {
        Intent i4 = new Intent(finalcalc.this, maleFat.class);
        ActivityOptions options = ActivityOptions.makeScaleUpAnimation(v, 0,
                0, v.getWidth(), v.getHeight());
        startActivity(i4,options.toBundle());
    }
    public void femfat(View v) {
        Intent i4 = new Intent(finalcalc.this, femFat.class);
        ActivityOptions options = ActivityOptions.makeScaleUpAnimation(v, 0,
                0, v.getWidth(), v.getHeight());
        startActivity(i4,options.toBundle());
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