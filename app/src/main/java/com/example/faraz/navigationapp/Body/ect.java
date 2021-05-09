package com.example.faraz.navigationapp.Body;


import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

import android.widget.TextView;


import com.example.faraz.navigationapp.R;


public class ect extends AppCompatActivity {


    TextView descText1;
    ImageButton show1, hide1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ect);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String ec2 = "Lato-Regular.ttf";
        Typeface ef = Typeface.createFromAsset(getAssets(), ec2);
        TextView ec1 = (TextView) findViewById(R.id.textView10);
        TextView ec0 = (TextView) findViewById(R.id.textView13);
        TextView ec3 = (TextView) findViewById(R.id.textView14);
        TextView ec4 = (TextView) findViewById(R.id.textView15);
        TextView ec5 = (TextView) findViewById(R.id.textView36);
        TextView ec6 = (TextView) findViewById(R.id.textView43);
        TextView ec7 = (TextView) findViewById(R.id.textView42);
        TextView ec8 = (TextView) findViewById(R.id.textView44);
        TextView ec9 = (TextView) findViewById(R.id.textView16);
        TextView ec10 = (TextView) findViewById(R.id.textView45);
        TextView ec11 = (TextView) findViewById(R.id.textView46);
        TextView ec12 = (TextView) findViewById(R.id.textView47);
        TextView ec13 = (TextView) findViewById(R.id.textView48);

        ec0.setTypeface(ef);
        ec1.setTypeface(ef);
        ec3.setTypeface(ef);
        ec4.setTypeface(ef);
        ec5.setTypeface(ef);
        ec6.setTypeface(ef);
        ec7.setTypeface(ef);
        ec8.setTypeface(ef);
        ec9.setTypeface(ef);
        ec10.setTypeface(ef);
        ec11.setTypeface(ef);
        ec12.setTypeface(ef);
        ec13.setTypeface(ef);



        descText1 = (TextView) findViewById(R.id.textView14);
        show1 = (ImageButton) findViewById(R.id.show1);
        show1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Show button");
                show1.setVisibility(View.INVISIBLE);
                hide1.setVisibility(View.VISIBLE);
                descText1.setMaxLines(Integer.MAX_VALUE);

            }
        });
        hide1 = (ImageButton) findViewById(R.id.hide1);
        hide1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Hide button");
                hide1.setVisibility(View.INVISIBLE);
                show1.setVisibility(View.VISIBLE);
                descText1.setMaxLines(5);

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


