package com.example.allinone1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.allinone1.entities.Person;

import org.w3c.dom.Text;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;

public class pointTwoThree extends AppCompatActivity {
    private TextView tvProducts;
    private TextView tvCounts;
    private TextView tvPrices;
    private TextView tvTotals;
    private TextView tvTotal;
    private TextView tvDate;
    private TextView tvTitular;
    private TextView tvAddress;
    private Button btOK;

    private HashMap<String,Integer> productsPrice = new HashMap<String,Integer>();
    private HashMap<String,Integer> productsCount = new HashMap<String,Integer>();

    @Override
    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_two_three);
        beginning();
        setItems();
        setUser();
    }

    private void theGoBackMachine(){
        Intent go = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(go);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void beginning() {
        LocalDate today = LocalDate.now();
        Bundle extraReciever = getIntent().getExtras();
        this.productsCount = (HashMap<String,Integer>) extraReciever.get("selectedProducts");

        this.productsPrice.put("Abedul",1000);
        this.productsPrice.put("Pine",1200);
        this.productsPrice.put("Acacia",1800);
        this.productsPrice.put("Roble",2700);
        this.productsPrice.put("Eucalipto",900);
        this.productsPrice.put("Aglomerado",1200);

        tvDate= findViewById(R.id.tvDate);
        tvProducts=findViewById(R.id.tvProducts);
        tvCounts=findViewById(R.id.tvCounts);
        tvPrices=findViewById(R.id.tvPrices);
        tvTotals=findViewById(R.id.tvTotals);
        tvTotal=findViewById(R.id.tvTotal);
        btOK = findViewById(R.id.btOK);
        tvTitular = findViewById(R.id.tvTitular);
        tvAddress = findViewById(R.id.tvAddress);

        tvDate.setText(today.toString());
    }

    private void setItems(){
        StringBuilder products = new StringBuilder();
        StringBuilder prices = new StringBuilder();
        StringBuilder counts = new StringBuilder();
        StringBuilder totals = new StringBuilder();
        Integer total;

        Iterator interator = this.productsCount.keySet().iterator();

        String key;

        while (interator.hasNext()){
            key=interator.next().toString();
            if(productsCount.get(key)!=0){
                products.append(key);
                prices.append(productsPrice.get(key));
                counts.append(productsCount.get(key));
                totals.append(productsPrice.get(key)*productsCount.get(key));

                products.append("\n");
                prices.append("\n");
                counts.append("\n");
                totals.append("\n");

            }
        }
        tvProducts.setText(products.toString());
        tvCounts.setText(counts.toString());
        tvPrices.setText(prices.toString());
        tvTotals.setText(totals.toString());
    }

    private void setUser(){
        Bundle extraReciever = getIntent().getExtras();
        Person titular =(Person) extraReciever.get("user");
        tvTitular.setText("Titular: "+titular.getLastName()+" "+titular.getName());
        tvAddress.setText("Address: "+titular.getAddress());
    }
}