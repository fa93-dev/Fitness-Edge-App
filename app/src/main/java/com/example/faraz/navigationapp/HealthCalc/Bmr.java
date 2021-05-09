package com.example.faraz.navigationapp.HealthCalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.faraz.navigationapp.R;

public class Bmr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final TextView heightUnit = (TextView)findViewById(R.id.heightUnit);
        final TextView weightUnit = (TextView)findViewById(R.id.weightUnit);
        final Button button = (Button) findViewById(R.id.submit);
        final TextView resultArea = (TextView) findViewById(R.id.bmiResult);

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
                    double bmr;
                    boolean isMale = true;
                    int age  = Integer.parseInt(((EditText) findViewById(R.id.ageValue)).getText().toString());
                    int height = Integer.parseInt(((EditText) findViewById(R.id.heightValue)).getText().toString());
                    int weight = Integer.parseInt(((EditText) findViewById(R.id.weightValue)).getText().toString());
                    RadioGroup sexGroup = (RadioGroup) findViewById(R.id.radiogroupSex);
                    RadioButton checked = (RadioButton)findViewById(sexGroup.getCheckedRadioButtonId());
                    switch (checked.getId()) {
                        case R.id.male:
                            isMale = true;
                            break;
                        case R.id.female:
                            isMale = false;
                            break;
                    }

                    if ((heightUnit.getText().toString()).equals("Inches")){
                        bmr = calculateBMRImperial((double) height,(double) weight,age, isMale);
                    }
                    else{
                        bmr = calculateBMRMetric((double) height,(double) weight, age, isMale);
                    }
                    resultArea.setText("Your base metabolic rate is: "+bmr+" calories burnt a day while at rest.");
                }
                catch (Exception a){
                    resultArea.setText("Must enter proper values for height, weight, and age.");
                }
            }
        });
    }

    public double calculateBMRMetric(double height, double weight, int age, boolean isMale){
        if(isMale) {
            return (10 * weight) + (6.25 * height) - (5 * age) + 5;
        }
        else{
            return (10 * weight) + (6.25 * height) - (5 * age) + 161;
        }
    }
    public double calculateBMRImperial(double height, double weight, int age, boolean isMale){
        weight*= 0.453592;
        height*=2.54;
        return calculateBMRMetric(height, weight, age, isMale);
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
