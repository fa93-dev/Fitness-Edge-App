package com.example.faraz.navigationapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.faraz.navigationapp.Body.ect;
import com.example.faraz.navigationapp.Body.end;
import com.example.faraz.navigationapp.Body.mes;

public class DietChart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_chart);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String cf2 = "Lato-Regular.ttf";
        Typeface tf3 = Typeface.createFromAsset(getAssets(), cf2);
        TextView td1 = (TextView) findViewById(R.id.textView9);
        TextView td2 = (TextView) findViewById(R.id.textView11);
        TextView td3 = (TextView) findViewById(R.id.textView12);
        td1.setTypeface(tf3);
        td2.setTypeface(tf3);
        td3.setTypeface(tf3);
    }

    public void ect_b(View view)
    {
        Intent intent = new Intent(DietChart.this,ect.class);
        ActivityOptions options = ActivityOptions.makeScaleUpAnimation(view, 0,
                0, view.getWidth(), view.getHeight());
        startActivity(intent,options.toBundle());

    }

    public void end_b(View view)
    {
        Intent intent = new Intent(DietChart.this,end.class);
        ActivityOptions options = ActivityOptions.makeScaleUpAnimation(view, 0,
                0, view.getWidth(), view.getHeight());
        startActivity(intent,options.toBundle());

    }

    public void mes_b(View view)
    {
        Intent intent = new Intent(DietChart.this,mes.class);
        ActivityOptions options = ActivityOptions.makeScaleUpAnimation(view, 0,
                0, view.getWidth(), view.getHeight());
        startActivity(intent,options.toBundle());

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
