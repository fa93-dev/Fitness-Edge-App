package com.example.faraz.navigationapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class AboutApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        String af = "Lato-Regular.ttf";
        Typeface af1 = Typeface.createFromAsset(getAssets(), af);
        TextView aV2 = (TextView) findViewById(R.id.about_text);
        aV2.setTypeface(af1);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            // Set the ActionBar title and up button
//        getActionBar().setTitle(getString(R.string.app_label));
//        getActionBar().setDisplayHomeAsUpEnabled(true);

            // Set the text
            TextView textView = (TextView) findViewById(R.id.about_text);
            textView.append(getString(R.string.about_part1));
            textView.append("\n\n");
            textView.append(getString(R.string.about_part2));
            textView.append("\n\n");
            textView.append(getString(R.string.about_part3));
            textView.append("\n\n\n\n");
            textView.append(getString(R.string.about_part4));
            textView.append("\n\n");
            textView.append(getString(R.string.about_part5));
            textView.append("\n\n");
            textView.append(getString(R.string.about_part6));

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

