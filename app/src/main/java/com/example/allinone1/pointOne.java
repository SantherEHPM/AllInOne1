package com.example.allinone1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pointOne extends AppCompatActivity {
    private Button btCalculate;
    private ImageButton ibReturn;
    private EditText etBirthdate;
    private TextView tvResult;


    @Override
    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_one);
        begining();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void begining(){
        this.btCalculate= findViewById(R.id.btCalculate);
        this.ibReturn = findViewById(R.id.ibReturn);
        this.etBirthdate = findViewById(R.id.etBirthdate);
        this.tvResult = findViewById(R.id.tvResult);
        this.ibReturn.setOnClickListener(this::theGoHomeMachine);
        this.btCalculate.setOnClickListener(this::calculate);
    }

    private void theGoHomeMachine(View view){
        Intent go = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(go);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void calculate(View view){
        LocalDate today = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthday;;
        boolean birthdayPassed;
        String birthdateStr;
        birthdateStr = etBirthdate.getText().toString();
        String patternStr = "^(\\d{2})/(\\d{2})/(\\d{4})$";
        Pattern pattern  = Pattern.compile(patternStr);
        Matcher validator = pattern.matcher(birthdateStr);
        if(!validator.find()){
            Toast.makeText(this, "The date is in a wrong format", Toast.LENGTH_SHORT).show();
            this.tvResult.setText("");
        }
        else{
            birthday = LocalDate.parse(birthdateStr, format);
            if(today.getYear()<birthday.getYear()){
                Toast.makeText(this, "The birthdate can't be higher than the actual date", Toast.LENGTH_SHORT).show();
            }
            else{
                birthdayPassed=(today.getMonthValue() > birthday.getMonthValue())||(today.getMonthValue() == birthday.getMonthValue() && today.getDayOfMonth()>=birthday.getDayOfMonth());
                this.tvResult.setText("Your edge is:"+(today.getYear()-birthday.getYear()-((!birthdayPassed)?(1):(0))));
            }
        }
    }
}