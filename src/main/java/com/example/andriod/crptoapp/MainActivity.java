package com.example.andriod.crptoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;




public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String spinMonths;
    private Spinner spinner;
    private Button proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        proceed = (Button) findViewById(R.id.go_btn);

        spinner = (Spinner) findViewById(R.id.crypto_spinner);

        //create arrayadapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.choose, R.layout.myspinner_item);

        // specify the layout to use when the list of choices appear
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //apply adapter to spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        validate();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinMonths = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void validate(){
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (spinMonths){
                    case "Bitcoin":
                        Intent intent = new Intent(MainActivity.this, Bitcoin.class);
                        startActivity(intent);
                        break;
                    case "Ethereum":
                        Intent intent1 = new Intent(MainActivity.this, Ethereum.class);
                        startActivity(intent1);
                }
            }
        });
    }
}

