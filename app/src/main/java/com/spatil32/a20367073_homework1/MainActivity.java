package com.spatil32.a20367073_homework1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity
{
    // private class members
    private EditText mealCost;
    private EditText taxPercentage;
    private EditText tipPercentage;
    private EditText totalMealCost;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the input values from the view using id of the element
        mealCost = (EditText) findViewById(R.id.txtMealCost);
        taxPercentage = (EditText) findViewById(R.id.txtTaxPercentage);
        tipPercentage = (EditText) findViewById(R.id.txtTipPercentage);
        totalMealCost = (EditText) findViewById(R.id.txtTotalMealCost);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        //onClick event for button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculateTotalMealCost();
            }
        });
    }
        //This function calculates the total bill amount by performing calculations on input fields.
        private void CalculateTotalMealCost()
        {
            Double cost = null, taxPercent = null, tipPercent = null;
            boolean condition = true;
            //while loop runs until all the valid inputs are provided in MealCost, TaxPercentage, TipPercentage input field.
            // If any of the field is blank and submit button is clicked, the app will generate a Toast to show error message.
            while (condition)
            {
                try {
                    cost = Double.parseDouble(mealCost.getText().toString());
                    condition = false;
                } catch (Exception e) {
                    //Toast for blank MealCost input field.
                    Toast.makeText(MainActivity.this, "Please Enter meal cost", Toast.LENGTH_LONG).show();
                    condition = true;
                    return;
                }
                try {
                    taxPercent = Double.parseDouble(taxPercentage.getText().toString());
                    condition = false;
                } catch (Exception e) {
                    //Toast for blank TaxPercentage input field.
                    Toast.makeText(MainActivity.this, "Please Enter tax percentage", Toast.LENGTH_LONG).show();
                    condition = true;
                    return;
                }

                try {
                    tipPercent = Double.parseDouble(tipPercentage.getText().toString());
                    condition = false;
                } catch (Exception e) {
                    //Toast for blank TipPercentage input field.
                    Toast.makeText(MainActivity.this, "Please Enter tip percentage", Toast.LENGTH_LONG).show();
                    condition = true;
                    return;
                }
            }

            Double overallMealCost = cost + (cost * taxPercent / 100) + (cost * tipPercent / 100);
            //set the calculated bill amount in TotalMealCost text field
            totalMealCost.setText(Double.toString(overallMealCost));
        }
}