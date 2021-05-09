package com.example.faraz.navigationapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.support.design.widget.Snackbar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.regex.Pattern;

public class Feedback extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {

    EditText nameField, emailField, feedbackField;
    Spinner feedbackSpinner;
    //FeedbackDataBaseAdapter feedbackDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Firebase.setAndroidContext(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (!isNetworkAvailable()) {
            // Create an Alert Dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setTitle("No Internet");
            builder.setMessage("Internet is required. Please Retry.");

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            });

            builder.setPositiveButton("Retry", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    dialog.dismiss();
                    checkConnection();

                }
            });
            AlertDialog dialog = builder.create(); // calling builder.create after adding buttons
            dialog.show();
        }
        checkConnection();
        //feedbackDataBaseAdapter = new FeedbackDataBaseAdapter(this);
       // feedbackDataBaseAdapter = feedbackDataBaseAdapter.open();
        String cusfn = "Lato-Regular.ttf";
        Typeface tyfc = Typeface.createFromAsset(getAssets(), cusfn);
        TextView tview = (TextView) findViewById(R.id.contact_form_title);
        tview.setTypeface(tyfc);
        nameField = (EditText) findViewById(R.id.nametxt);
        emailField = (EditText) findViewById(R.id.emailtxt);
        feedbackField = (EditText) findViewById(R.id.msgtxt);
        feedbackSpinner = (Spinner) findViewById(R.id.SpinnerFeedbackType);


        Button fbsubmit = (Button) findViewById(R.id.fbsub);
        // Manually checking internet connection


        fbsubmit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                checkConnection();
                //Creating firebase object
                Firebase ref = new Firebase(Config.FIREBASE_URL);

                String editname = nameField.getText().toString();
                if (!(Pattern.matches("^[\\p{L} .'-]+$", nameField.getText()))) {
                    nameField.setError("Please Enter Valid Name");
                    nameField.setFocusable(true);
                }

                String editemail = emailField.getText().toString().trim();

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (editemail.matches(emailPattern))
                {}
                else
                {
                    emailField.setError("Invalid Email");
                    nameField.setFocusable(true);
                }

                String feedback = feedbackField.getText().toString();
                if (feedback.equals(""))
                {
                    feedbackField.setError("Description please!!");
                    feedbackField.setFocusable(true);
                }
                String feedbackType = feedbackSpinner.getSelectedItem().toString();
                int pos = feedbackSpinner.getSelectedItemPosition();
                if(pos==0)
                {

                    Toast.makeText(getApplicationContext(), "Please Pick One Option !!", Toast.LENGTH_LONG).show();
                    feedbackSpinner.requestFocusFromTouch();
                    return;
                }


                if(editname.equals("")||editemail.equals("")||feedback.equals("") )
                {
                    Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                    return;
                }

                else
                {

                FeedbackData feedbackData = new FeedbackData();

                feedbackData.setName(editname);
                feedbackData.setEmail(editemail);
                feedbackData.setFeedback(feedback);
                feedbackData.setFeedbackType(feedbackType);

                //Storing values to firebase
                Firebase newRef = ref.child("FeedbackData").push();
                newRef.setValue(feedbackData);
                    Toast.makeText(getApplicationContext(), "Successfully Submitted ", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Feedback.this,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                //Value event listener for realtime data update
             /*   ref.addValueEventListener(new ValueEventListener() {
                   @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                            //Getting the data from snapshot
                            FeedbackData feedbackData = postSnapshot.getValue(FeedbackData.class);

                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        System.out.println("The read failed: " + firebaseError.getMessage());
                    }
                }); */

            }
        });
    }

    // Method to manually check connection status
    private void checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        showSnack(isConnected);
    }

    // Showing the status in Snackbar
    private void showSnack(boolean isConnected) {
        String message;
        int color;
        if (isConnected) {
            message = "Good! Connected to Internet";
            color = Color.WHITE;
        } else {
            message = "Sorry! Not connected to internet.";
            color = Color.RED;

        }

        Snackbar snackbar = Snackbar.make(findViewById(R.id.fbsub), message, Snackbar.LENGTH_LONG);

        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(color);
        snackbar.show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // register connection status listener
        MyApplication.getInstance().setConnectivityListener(this);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showSnack(isConnected);
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

    private boolean isNetworkAvailable() {
        // Using ConnectivityManager to check for Network Connection
        ConnectivityManager connectivityManager = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
}








