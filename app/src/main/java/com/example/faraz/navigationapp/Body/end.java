package com.example.faraz.navigationapp.Body;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.faraz.navigationapp.R;

public class end extends AppCompatActivity {
    TextView descText;
    ImageButton show, hide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String en0 = "Lato-Regular.ttf";;
        Typeface en = Typeface.createFromAsset(getAssets(), en0);
        TextView en1 = (TextView) findViewById(R.id.textView19);
        TextView en2 = (TextView) findViewById(R.id.textView20);
        TextView en3 = (TextView) findViewById(R.id.textView21);
        TextView en4 = (TextView) findViewById(R.id.textView32);
        TextView en5 = (TextView) findViewById(R.id.textView39);
        TextView en6 = (TextView) findViewById(R.id.textView33);
        TextView en7 = (TextView) findViewById(R.id.textView40);
        TextView en8 = (TextView) findViewById(R.id.textView41);
        TextView en9 = (TextView) findViewById(R.id.textView34);
        TextView en10 = (TextView) findViewById(R.id.textView38);
        TextView en11 = (TextView) findViewById(R.id.textView37);
        TextView en12 = (TextView) findViewById(R.id.textView35);

        en1.setTypeface(en);
        en2.setTypeface(en);
        en3.setTypeface(en);
        en4.setTypeface(en);
        en5.setTypeface(en);
        en6.setTypeface(en);
        en7.setTypeface(en);
        en8.setTypeface(en);
        en9.setTypeface(en);
        en10.setTypeface(en);
        en11.setTypeface(en);
        en12.setTypeface(en);



        descText = (TextView) findViewById(R.id.textView21);
        show = (ImageButton) findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Show button");
                show.setVisibility(View.INVISIBLE);
                hide.setVisibility(View.VISIBLE);
                descText.setMaxLines(Integer.MAX_VALUE);

            }
        });
        hide = (ImageButton) findViewById(R.id.hide);
        hide.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Hide button");
                hide.setVisibility(View.INVISIBLE);
                show.setVisibility(View.VISIBLE);
                descText.setMaxLines(5);

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






