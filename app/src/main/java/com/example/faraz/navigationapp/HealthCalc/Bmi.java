package com.example.faraz.navigationapp.HealthCalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.faraz.navigationapp.R;

public class Bmi extends AppCompatActivity {


    public static String BMIStatus ;
    private TextView adTexView;
    private TextView disAdTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        final TextView heightUnit = (TextView)findViewById(R.id.heightUnit);
        final TextView weightUnit = (TextView)findViewById(R.id.weightUnit);
        final Button button = (Button) findViewById(R.id.submit);
        final TextView resultArea = (TextView) findViewById(R.id.bmiResult);
        adTexView = (TextView) findViewById(R.id.advantageTextView);
        disAdTextView = (TextView) findViewById(R.id.disadvantageTextView);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked)
            {
                switch(checked)
                {
                    case R.id.imperial:
                        heightUnit.setText(R.string.inches);
                        weightUnit.setText(R.string.pounds);
                        break;
                    case R.id.metric:
                        heightUnit.setText(R.string.cm);
                        weightUnit.setText(R.string.kg);
                        break;
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double bmi;
                    String fbmi = null;
                    int height = Integer.parseInt(((EditText) findViewById(R.id.heightValue)).getText().toString());
                    int weight = Integer.parseInt(((EditText) findViewById(R.id.weightValue)).getText().toString());
                    if ((heightUnit.getText().toString()).equals("Inches")){
                        bmi = calculateBMIImperial((double) height,(double) weight);
                    }
                    else{
                        bmi = calculateBMIMetric((double) height,(double) weight);
                        fbmi = String.format("%.2f", bmi);
                    }
                    //resultArea.setText("BMI: "+bmi);
                    if (bmi < 18.5) {
                        resultArea.setText("Your BMI is:   " + fbmi +
                                "\nBMI status:  You are Underweight. \n");
                        adTexView.setText("Advantages are limited");
                        disAdTextView.setText("* Miscarriage and pregnancy problems\n"
                                + " * Male fertility issues"
                                + "\n* Lung problem during old age  "
                                + "\n* Arthritis  ");
                        BMIStatus = "UNDERWEIGHT";
                    }
                        else if ((bmi >= 18.5) && (bmi <= 24.9)) {
                        resultArea.setText("Your BMI is:   " + fbmi
                                + "\nBMI status:    You have a Normal BMI. ");
                        adTexView.setText("* Lower risk of stroke and heart disease"
                                + "\n* Lower risk of cancer"
                                + "\n* More energy");
                        disAdTextView.setText("* Null");
                        BMIStatus = "NORMAL";
                        }
                    else if ((bmi > 24.9) && (bmi <= 29.5)) {
                        resultArea.setText("Your BMI is:   " + fbmi + "\nBMI status:  You are Overweight(Lower limit of Obessity)");
                            adTexView.setText("* More warmth is possible"
                                    + "\n* Stronger bones/muscle"
                                    + "\n* Overweight people can lose weight");
                            disAdTextView.setText("* vulnerable to High blood pressure"
                                    + "\nHigh risk of stroke"
                                    + "\n* High risk of Diabetes ");
                            BMIStatus = "OVERWEIGHT";
                        }
                    else if (bmi > 29.5) {
                        resultArea.setText("Your BMI is:   " + fbmi
                                    + "\nBMI status:    You are Obessed");
                            adTexView.setText(" * More warmth is possible"
                                    + "* Stronger bones/muscle"
                                    + "\n* Obessed people can lose weight");
                            disAdTextView.setText("* vulnerable to High blood pressure"
                                    + "\n* High risk of stroke"
                                    + "\n* High risk of Diabetes "
                                    + "\n* High risk of ostheoarthritis"
                                    + "\n\nWARNING: You really need to burn some fat.");
                            BMIStatus = "OBESSED";
                        }
                    }

                catch (Exception a){
                    resultArea.setText("Must enter proper values for height and weight.");
                }

            }
        });

    }

    public double calculateBMIImperial(double height, double weight){
        double result = (weight * 703)/ Math.pow(height, 2);
        return result;
    }
    public double calculateBMIMetric(double height, double weight){
        double result = ((weight / height)/height) *10000.0;
        return result;
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
