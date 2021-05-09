package com.example.faraz.navigationapp.Body;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.faraz.navigationapp.R;

public class mes extends AppCompatActivity {
    TextView descText2;
    ImageButton show2, hide2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String me0 = "Lato-Regular.ttf";
        Typeface me = Typeface.createFromAsset(getAssets(), me0);
        TextView me1 = (TextView) findViewById(R.id.textView8);
        TextView me2 = (TextView) findViewById(R.id.textView18);
        TextView me3 = (TextView) findViewById(R.id.textView17);
        TextView me4 = (TextView) findViewById(R.id.textView22);
        TextView me5 = (TextView) findViewById(R.id.textView23);
        TextView me6 = (TextView) findViewById(R.id.textView24);
        TextView me7 = (TextView) findViewById(R.id.textView25);
        TextView me8 = (TextView) findViewById(R.id.textView26);
        TextView me9 = (TextView) findViewById(R.id.textView27);
        TextView me10 = (TextView) findViewById(R.id.textView28);
        TextView me11 = (TextView) findViewById(R.id.textView29);
        TextView me12 = (TextView) findViewById(R.id.textView30);
        TextView me13 = (TextView) findViewById(R.id.textView31);
        me1.setTypeface(me);
        me2.setTypeface(me);
        me3.setTypeface(me);
        me4.setTypeface(me);
        me5.setTypeface(me);
        me6.setTypeface(me);
        me7.setTypeface(me);
        me8.setTypeface(me);
        me9.setTypeface(me);
        me10.setTypeface(me);
        me11.setTypeface(me);
        me12.setTypeface(me);
        me13.setTypeface(me);

        descText2 = (TextView) findViewById(R.id.textView18);
        show2 = (ImageButton) findViewById(R.id.show3);
        show2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Show button");
                show2.setVisibility(View.INVISIBLE);
                hide2.setVisibility(View.VISIBLE);
                descText2.setMaxLines(Integer.MAX_VALUE);

            }
        });
        hide2 = (ImageButton) findViewById(R.id.hide3);
        hide2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println("Hide button");
                hide2.setVisibility(View.INVISIBLE);
                show2.setVisibility(View.VISIBLE);
                descText2.setMaxLines(5);

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

