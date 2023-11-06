package com.example.allinone1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.allinone1.entities.Person;

public class pointTwoOne extends AppCompatActivity {
    private EditText etName;
    private EditText etLastName;
    private EditText etAddress;
    private Button btEnter;
    private ImageButton btReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_two_one);
        beginning();
        this.btEnter.setOnClickListener(this::logIn);
    }

    private void beginning(){
        this.etName = findViewById(R.id.etName);
        this.etLastName = findViewById(R.id.etLastName);
        this.etAddress = findViewById(R.id.etAddress);
        this.btEnter = findViewById(R.id.btEnter);
        this.btReturn = findViewById(R.id.ibReturn);
    }

    private void theGoHomeMachine(View view){
        Intent go = new Intent(getApplicationContext(), pointTwoOne.class);
        startActivity(go);
    }
    private void logIn(View view){
        String name;
        String lastName;
        String address;
        name=etName.getText().toString();
        lastName=etLastName.getText().toString();
        address=etAddress.getText().toString();
        Intent go = new Intent(getApplicationContext(),pointTwoTwo.class);
        if(!name.isEmpty() && !lastName.isEmpty()  && !address.isEmpty()){
            Person user = new Person(name,lastName,address);
            go.putExtra("user",user);
            startActivity(go);
        }
        else{
            Toast.makeText(this, "There is empty fields yet", Toast.LENGTH_SHORT).show();
        }

    }
}