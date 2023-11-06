package com.example.allinone1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.allinone1.entities.Person;

import java.util.HashMap;
import java.util.Iterator;

public class pointTwoTwo extends AppCompatActivity {

    private Button btProduct1;
    private Button btProduct2;
    private Button btProduct3;
    private Button btProduct4;
    private Button btProduct5;
    private Button btProduct6;
    private Button btBuy;
    private TextView tvSelected;

    private ImageButton ibReturn;

    private HashMap<String,Integer> products = new HashMap<String,Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_two_two);
        beginning();
    }
    private void theGoHomeMachine(View view){
        Intent go = new Intent(getApplicationContext(), pointTwoOne.class);
        startActivity(go);
    }
    private void beginning(){
        this.btProduct1=findViewById(R.id.btProduct1);
        this.btProduct2=findViewById(R.id.btProduct2);
        this.btProduct3=findViewById(R.id.btProduct3);
        this.btProduct4=findViewById(R.id.btProduct4);
        this.btProduct5=findViewById(R.id.btProduct5);
        this.btProduct6=findViewById(R.id.btProduct6);
        this.ibReturn=findViewById(R.id.ibReturn);
        this.btBuy = findViewById(R.id.btBuy);
        this.tvSelected=findViewById(R.id.tvSelectedProducts);
        btBuy.setEnabled(false);
        this.products.put("Abedul",0);
        this.products.put("Pine",0);
        this.products.put("Acacia",0);
        this.products.put("Roble",0);
        this.products.put("Eucalipto",0);
        this.products.put("Aglomerado",0);
        btProduct1.setOnClickListener(this::addProduct1);
        btProduct2.setOnClickListener(this::addProduct2);
        btProduct3.setOnClickListener(this::addProduct3);
        btProduct4.setOnClickListener(this::addProduct4);
        btProduct5.setOnClickListener(this::addProduct5);
        btProduct6.setOnClickListener(this::addProduct6);
        ibReturn.setOnClickListener(this::theGoHomeMachine);
        btBuy.setOnClickListener(this::buy);
    }
    private void printSelected(){
        Iterator<String> iterator = products.keySet().iterator();
        StringBuilder selected=new StringBuilder();
        String product;
        do{
            product=iterator.next();
            int cant = products.get(product);
            if(cant>0){
                selected.append(product);
                selected.append("\t\t");
                selected.append(cant);
                selected.append("\n");
            }
        }while(iterator.hasNext());
        tvSelected.setText(selected.toString()+"");
    }


    private void addProduct(String product){
        int cant = this.products.get(product);
        cant++;
        this.products.put(product,cant);
        printSelected();
        btBuy.setEnabled(true);
    }
    private void addProduct1(View view){
        addProduct("Abedul");
    }

    private void addProduct2(View view){
        addProduct("Pine");
    }
    private void addProduct3(View view){
        addProduct("Acacia");
    }
    private void addProduct4(View view){
        addProduct("Roble");
    }
    private void addProduct5(View view){
        addProduct("Eucalipto");
    }
    private void addProduct6(View view){
        addProduct("Aglomerado");
    }

    private void buy(View view){
        Intent go = new Intent(getApplicationContext(), pointTwoThree.class);
        Bundle extraReciever = getIntent().getExtras();
        go.putExtra("selectedProducts",products);
        go.putExtra("user",(Person)extraReciever.get("user"));
        startActivity(go);
    }
}