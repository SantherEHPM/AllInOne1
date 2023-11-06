package com.example.allinone1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;

public class pointThree extends AppCompatActivity {
    private RadioButton answer1;
    private RadioButton answer2;
    private RadioButton answer3;
    private RadioButton answer4;
    private RadioButton answer5;
    private RadioButton answer6;
    private Button btSend;

    private ImageButton ibReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_three);
        beginning();
    }

    private void beginning() {
        answer1 = findViewById(R.id.rbAnswerV1);
        answer2 = findViewById(R.id.rbAnswerV2);
        answer3 = findViewById(R.id.rbAnswerV3);
        answer4 = findViewById(R.id.rbAnswerV4);
        answer5 = findViewById(R.id.rbAnswerV5);
        answer6 = findViewById(R.id.rbAnswerV6);
        btSend = findViewById(R.id.btSend);
        ibReturn = findViewById(R.id.ibReturn);

        btSend.setOnClickListener(this::evaluate);
        ibReturn.setOnClickListener(this::theGoBackMachine);
    }

    private void theGoBackMachine(View view){
        Intent go = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(go);
    }
    private void evaluate(View view){
        int acerts = 0;
        String message ="";
        if(answer1.isChecked()){
            acerts++;
        }
        if(answer2.isChecked()){
            acerts++;
        }
        if(answer3.isChecked()){
            acerts++;
        }
        if(answer4.isChecked()){
            acerts++;
        }
        if(answer5.isChecked()){
            acerts++;
        }
        if(answer6.isChecked()){
            acerts++;
        }
        switch(acerts){
            case 1:
            case 2: message = "Lee mas, y vualve como una persona de cultura a ponerte a prueba 🧐";
                    break;
            case 3:
            case 4: message = "Buen intento, pero te faltan la preguntas mas escenciales 😫";
                    break;
            case 5:
            case 6: message = "enEfecto, eres todo un culto, QUE FINO 🗿";
        };

        Log.i("Responded","Questionario respondido");

        new AlertDialog.Builder(this)
                .setTitle("Test terminado")
                .setMessage(acerts+"/6\n"+message)
                .setPositiveButton("Volver a intentar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        answer1.setChecked(false);
                        answer2.setChecked(false);
                        answer3.setChecked(false);
                        answer4.setChecked(false);
                        answer5.setChecked(false);
                        answer6.setChecked(false);
                    }
                }).setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent go = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(go);
                    }
                }).create().show();
    }
}