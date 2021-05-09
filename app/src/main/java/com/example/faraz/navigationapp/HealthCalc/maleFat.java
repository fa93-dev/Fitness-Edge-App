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

public class maleFat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malefat);
        final TextView resultfat = (TextView) findViewById(R.id.textBF);
        final TextView resfatperc = (TextView) findViewById(R.id.textBFP);
        final Button but2 = (Button) findViewById(R.id.fat1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double A1;
                    double A2;
                    double B;
                    double BF;   // body fat
                    double BFP;  // body fat percentage
                    String BFString;    // body fat string
                    String BFPString;   // body fat percentage
                    double bw1 = Double.parseDouble(((EditText) findViewById(R.id.wmal)).getText().toString());
                    double bw = bw1*2.20462;
                    double wMale = Double.parseDouble(((EditText) findViewById(R.id.wmal1)).getText().toString());
                    A1 = (bw * 1.082) + 94.42;
                    A2 = wMale * 4.15;
                    B = A1 - A2;
                    BF = bw - B;
                    BFP = BF * 100 / bw;
                    BFString = String.format("%.2f", BF);
                    resultfat.setText(BFString);
                    BFPString = String.format("%.2f ", BFP);
                    resfatperc.setText(BFPString);
                }
                catch
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





