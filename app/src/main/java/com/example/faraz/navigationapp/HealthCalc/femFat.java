package com.example.faraz.navigationapp.HealthCalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.faraz.navigationapp.R;

public class femFat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_femfat);
        final TextView femresfat = (TextView) findViewById(R.id.res1);
        final TextView femfatperc = (TextView) findViewById(R.id.femres1);
        final Button but3 = (Button) findViewById(R.id.fatfembut);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double A1;
                    double A2;
                    double A3;
                    double A4;
                    double A5;
                    double B;
                    double bW1;   // body weight
                    double wM;   // waist measurement
                    double wrM;  // wrist measurement
                    double hM;   // hip measurement
                    double fM;   // forearm measurement
                    double BF;   // body fat
                    double BFP;  // body fat percentage
                    String BFString;    // body fat string
                    String BFPString;   // body fat percentage
                    bW1= Double.parseDouble(((EditText) findViewById(R.id.femw)).getText().toString());
                    double bW = bW1*2.20462;                    wM = Double.parseDouble(((EditText) findViewById(R.id.femwai)).getText().toString());
                    wrM = Double.parseDouble(((EditText) findViewById(R.id.femwrist)).getText().toString());
                    hM = Double.parseDouble(((EditText) findViewById(R.id.femhip)).getText().toString());
                    fM = Double.parseDouble(((EditText) findViewById(R.id.femfore)).getText().toString());


                    A1 = (bW * 0.732) + 8.987;
                    A2 = (wM * 0.157);
                    A3 = (wrM / 3.14);
                    A4 = (hM * 0.249);
                    A5 = (fM * 0.434);

                    B = A1 + A2 + A3 + A4 + A5;

                    BF = bW - B;

                    BFP = BF * 100 / bW;
                    BFString = String.format("%.2f", BF);
                    femresfat.setText(BFString);
                    BFPString = String.format("%.2f", BFP);
                    femfatperc.setText(BFPString);
                }catch

                        (Exception a){
                    Toast.makeText(getApplicationContext(), "Enter all Values", Toast.LENGTH_LONG).show();
                    return;
                }


            }
        });

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