package com.app.multicalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class DiscountCalculator extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount_calculator);




    }

    public void applyDiscount(View view){
        EditText priceText = (EditText) findViewById(R.id.price);
        EditText percentageText = (EditText) findViewById(R.id.percentage);
        TextView calcResult = (TextView) findViewById(R.id.calcResult);
        if (priceText.getText().toString().equals("")){
            Toast.makeText(DiscountCalculator.this, "Price field is empty", Toast.LENGTH_SHORT).show();
        }
        else if (percentageText.getText().toString().equals("")){
            Toast.makeText(DiscountCalculator.this, "Discount field is empty", Toast.LENGTH_SHORT).show();
        }
        else if (Double.valueOf(percentageText.getText().toString()) >= 101) {
            Toast.makeText(DiscountCalculator.this, "You cannot discount beyond 101%", Toast.LENGTH_SHORT).show();
        }
        else {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            double price = Double.valueOf(priceText.getText().toString());
            double percentage = Double.valueOf(percentageText.getText().toString());
            double onePerc = price / 100;
            double PercOff = 100 - percentage;
            double result = onePerc * PercOff;
            double finalResult = Math.round(result * 100.0) / 100.0;
            calcResult.setText(String.valueOf("Discounted price:" + '\n' + finalResult));
        }
    }

    @Override
    public void onBackPressed() {

            super.onBackPressed();
        }
    }

