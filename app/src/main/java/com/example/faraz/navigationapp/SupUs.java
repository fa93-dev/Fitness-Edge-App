package com.example.faraz.navigationapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.faraz.navigationapp.R.id.toolbar;

public class SupUs extends AppCompatActivity {
    private FloatingActionButton fabapp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sup_us);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        fabapp = (FloatingActionButton) findViewById(R.id.fab1);
        fabapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SupUs.this, AboutApp.class);
                ActivityOptions options = ActivityOptions.makeScaleUpAnimation(view, 0,
                        0, view.getWidth(), view.getHeight());
                startActivity(intent,options.toBundle());
            }
        });

        String cf = "Lato-Regular.ttf";
        Typeface tf1 = Typeface.createFromAsset(getAssets(), cf);
        TextView tV1 = (TextView) findViewById(R.id.textView54);
        TextView tV2 = (TextView) findViewById(R.id.textView57);
        tV1.setTypeface(tf1);
        tV2.setTypeface(tf1);

        Button regBut = (Button) findViewById(R.id.reg_now); // Retrieve the button from the XML file
        regBut.setOnClickListener(new View.OnClickListener() {  //Add a listener for when the button is pressed
            @Override
            public void onClick(View v) {
                sendTofit();
            }
        });



    Button fbBut = (Button) findViewById(R.id.buttonfb); // Retrieve the button from the XML file
        fbBut.setOnClickListener(new View.OnClickListener() {  //Add a listener for when the button is pressed
            @Override
            public void onClick(View v) {
                sendTofb();
            }
        });
    }

    protected void sendTofb() {
        String url = "https://www.facebook.com/FitnessEdge.in/"; // You could have this at the top of the class as a constant, or pass it in as a method variable, if you wish to send to multiple websites
        Intent i = new Intent(Intent.ACTION_VIEW); // Create a new intent - stating you want to 'view something'
        i.setData(Uri.parse(url));  // Add the url data (allowing android to realise you want to open the browser)
        startActivity(i); // Go go go!
    }


     protected void sendTofit() {
        String url = "http://fitnessedge.in/packages.php"; // You could have this at the top of the class as a constant, or pass it in as a method variable, if you wish to send to multiple websites
        Intent i = new Intent(Intent.ACTION_VIEW); // Create a new intent - stating you want to 'view something'
        i.setData(Uri.parse(url));  // Add the url data (allowing android to realise you want to open the browser)
        startActivity(i); // Go go go!
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


