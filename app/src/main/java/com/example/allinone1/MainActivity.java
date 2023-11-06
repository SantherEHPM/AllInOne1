package com.example.allinone1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButtonToggleGroup;

public class MainActivity extends AppCompatActivity {
    private Button btOne;
    private Button btTwo;
    private Button btThree;
    private Button btFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        begining();
        btOne.setOnClickListener(this::goToOne);
        btTwo.setOnClickListener(this::goToTwo);
        btThree.setOnClickListener(this::goToThree);
        btFour.setOnClickListener(this::goToFour);
    }

    private void begining(){
        this.btOne=findViewById(R.id.btOne);
        this.btTwo=findViewById(R.id.btTwo);
        this.btThree=findViewById(R.id.btThree);
        this.btFour=findViewById(R.id.btFour);
    }

    private void goToOne(View view){
        Intent go =new Intent(getApplicationContext(), pointOne.class);
        startActivity(go);
    }

    private void goToTwo(View view){
        Intent go =new Intent(getApplicationContext(), pointTwoOne.class);
        startActivity(go);
    }

    private void goToThree(View view){
        Intent go =new Intent(getApplicationContext(), pointThree.class);
        startActivity(go);
    }

    private void goToFour(View view){
        Intent go =new Intent(getApplicationContext(), pointFour.class);
        startActivity(go);
    }
}