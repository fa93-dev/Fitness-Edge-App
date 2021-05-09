package com.example.faraz.navigationapp;

import android.app.ActivityOptions;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.appindexing.FirebaseAppIndexingTooManyArgumentsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;

import android.support.v4.app.SupportActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.faraz.navigationapp.HealthCalc.Bmi;
import com.example.faraz.navigationapp.HealthCalc.Bmr;
import com.example.faraz.navigationapp.HealthCalc.MacroNutri;
import com.example.faraz.navigationapp.caloriecounter.Main3Activity;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fab;
    private RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       toolbar.hideOverflowMenu();
       setSupportActionBar(toolbar);


        String hd1 = "Lato-Regular.ttf";
        Typeface hf2 = Typeface.createFromAsset(getAssets(), hd1);
        TextView tm1 = (TextView) findViewById(R.id.textView6);
        TextView tm2 = (TextView) findViewById(R.id.textView4);
        TextView tm3 = (TextView) findViewById(R.id.textView7);
        TextView tm5 = (TextView) findViewById(R.id.text2);
        TextView tm6 = (TextView) findViewById(R.id.text3);
        TextView tm7 = (TextView) findViewById(R.id.text4);
       // TextView tm8 = (TextView) findViewById(R.id.textView49);
        tm1.setTypeface(hf2);
        tm2.setTypeface(hf2);
        tm3.setTypeface(hf2);
        tm5.setTypeface(hf2);
        tm6.setTypeface(hf2);
        tm7.setTypeface(hf2);
       // tm8.setTypeface(tf2);




        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Feedback.class);
                ActivityOptions options = ActivityOptions.makeScaleUpAnimation(view, 0,
                        0, view.getWidth(), view.getHeight());
                startActivity(intent,options.toBundle());
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home) {
                    Intent i = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(i);
                    // Handle the preference  action
                }
                else if (id == R.id.steps) {
                    Intent i = new Intent(MainActivity.this, PedometerActivity.class);
                    startActivity(i);
                    // Handle the About action
                }
                else if (id == R.id.exe) {
                    Intent i = new Intent(MainActivity.this, WorkoutListActivity.class);
                    startActivity(i);
                    // Handle the About action
                } else if (id == R.id.act) {
                    Intent i = new Intent(MainActivity.this, WorkCal.class);
                    startActivity(i);
                    // Handle the About action
                } else if (id == R.id.calc) {
                    Intent i = new Intent(MainActivity.this, finalcalc.class);
                    startActivity(i);
                    // Handle the About action
                } else if (id == R.id.BodInfo) {
                    Intent i = new Intent(MainActivity.this, DietChart.class);
                    startActivity(i);
                    // Handle the About action
                }
                else if (id == R.id.prof) {
                    Intent i = new Intent(MainActivity.this, Profile.class);
                    startActivity(i);
                    // Handle the About action
                }

                else if (id == R.id.con_us) {
                    Intent i = new Intent(MainActivity.this, Contact.class);
                    startActivity(i);
                    // Handle the About action
                }
                else if (id == R.id.cal_log) {
                    Intent i = new Intent(MainActivity.this, Main3Activity.class);
                    startActivity(i);
                    // Handle the About action
                }
                else if (id == R.id.absus) {
                    Intent i = new Intent(MainActivity.this, About.class);
                    startActivity(i);
                    // Handle the About action
                }
                else if (id == R.id.supus) {
                    Intent i = new Intent(MainActivity.this,SupUs.class);
                    startActivity(i);
                    // Handle the About action
                }
              /*  else if (id == R.id.reg_fit) {
                    Intent i = new Intent(MainActivity.this,Register.class);
                    startActivity(i);
                    // Handle the About action
                }
                else if (id == R.id.action_feed) {
                    Intent i = new Intent(MainActivity.this,Feedback.class);
                    startActivity(i);
                    // Handle the About action
                } */
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main; this adds items to the action bar if it is present.


        getMenuInflater().inflate(R.menu.main, menu);
         return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
         int id = item.getItemId();


     /*   if (id == R.id.reg_fit) {
            Intent i = new Intent(MainActivity.this,Register.class);
            startActivity(i);
             return true;
            // Handle the About action
        }
        else if (id == R.id.action_feed) {
            Intent i = new Intent(MainActivity.this,Feedback.class);
            startActivity(i);
             return true;
            // Handle the About action

        //noinspection SimplifiableIfStatement

        }*/
        return super.onOptionsItemSelected(item);
    }


}











