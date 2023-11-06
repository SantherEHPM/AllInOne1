package com.example.allinone1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pointFour extends AppCompatActivity {

    private EditText etWeight;
    private EditText etHeight;
    private Button btCalculate;

    private ImageButton btReturn;
    private TextView tvResult;
    private TextView tvResult2;

    private Switch swSystem;
    private Boolean metricSystem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_four);
        beginnig();
    }

    private void theGoHomeMachine(View view){
        Intent go = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(go);
    }
    private void beginnig() {
        etWeight=findViewById(R.id.etWeight);
        etHeight =findViewById(R.id.etHeight);
        btCalculate=findViewById(R.id.btCalculate);
        tvResult = findViewById(R.id.tvResult);
        tvResult2 = findViewById(R.id.tvResult2);
        swSystem = findViewById(R.id.swSystem);
        metricSystem = !swSystem.isChecked();
        btReturn = findViewById(R.id.ibReturn);

        btCalculate.setOnClickListener(this::calculate);
        swSystem.setOnClickListener(this::changeSystem);
        btReturn.setOnClickListener(this::theGoHomeMachine);
    }

    private void calculate(View view){
        float imc;
        float weight;
        float height;
        if(!etHeight.getText().toString().isEmpty() && !etWeight.getText().toString().isEmpty()){
            weight=Float.parseFloat(etWeight.getText().toString());
            height=Float.parseFloat(etHeight.getText().toString());
            imc = (float) (weight/Math.pow(height,2.0f));
            tvResult.setText("Your imc is: "+imc);
            if(metricSystem){
                if(imc<18.5){
                    tvResult2.setText("Underweight");
                }
                else if(imc<24.9){
                    tvResult2.setText("Normal");
                }
                else if(imc<30){
                    tvResult2.setText("Overweight");
                }
                else{
                    tvResult2.setText("Obese");
                }
            }
            else {
                if(imc<3.6){
                    tvResult2.setText("Underweight");
                }
                else if(imc<5.2){
                    tvResult2.setText("Underweight");
                }
                else if(imc<6.2){
                    tvResult2.setText("Overweight");
                }
                else{
                    tvResult2.setText("Obese");
                }
            }
        }
        else{
            Toast.makeText(this, "Some field is empty", Toast.LENGTH_SHORT).show();
        }

    }
    private void changeSystem(View view){
        metricSystem = !swSystem.isChecked();
        if(metricSystem){
            etWeight.setHint("Enter your weight(kg)");
            etHeight.setHint("Enter your height(m)");
        }
        else{
            etWeight.setHint("Enter your weight(lb)");
            etHeight.setHint("Enter your height(ft)");
        }
        calculate(view);
    }
}