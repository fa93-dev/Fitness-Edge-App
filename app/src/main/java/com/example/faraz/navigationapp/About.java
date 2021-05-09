package com.example.faraz.navigationapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        String af = "Lato-Regular.ttf";
        String af2 = "Lato-Light.ttf";
        Typeface afh = Typeface.createFromAsset(getAssets(),af2);
        Typeface af1 = Typeface.createFromAsset(getAssets(),af);
        TextView aV1 = (TextView) findViewById(R.id.head);
        TextView aV2 = (TextView) findViewById(R.id.sub);
        TextView aV3 = (TextView) findViewById(R.id.head1);
        TextView aV4 = (TextView) findViewById(R.id.sub1);
        aV1.setTypeface(af1);
        aV2.setTypeface(afh);
        aV3.setTypeface(af1);
        aV4.setTypeface(afh);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
