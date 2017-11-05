package com.example.andriod.crptoapp;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by Boluwatife on 10/31/2017.
 */



public class Conversion extends AppCompatActivity {

    private TextView txt1,txt2,txt3,txt4,txt5,convertedTxt;
    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
        txt1 =(TextView)findViewById(R.id.page);
        txt2 =(TextView)findViewById(R.id.country);
        txt3 = (TextView)findViewById(R.id.currency);
        txt4 = (TextView)findViewById(R.id.crypto);
        txt5 = (TextView)findViewById(R.id.countryCode);
        convertedTxt = (TextView) findViewById(R.id.convertedText);
        editText = (EditText) findViewById(R.id.editext);
        button = (Button) findViewById(R.id.convertButton);

        Intent i = this.getIntent();


        if (i!=null){
            String data = i.getExtras().getString("bitcoins");
            if (data.equals("bitcoins")){
                Bundle bundle = getIntent().getBundleExtra("bit");
                if (bundle==null){
                    finish();
                }else {
                    String page = bundle.getString("BitIntent");
                    String country = bundle.getString("country");
                    String countryCode = bundle.getString("countryCode");
                    final String currency = bundle.getString("currency");

                    txt1.setText(page);
                    txt2.setText(country);
                    txt3.setText(currency);
                    txt4.setText(page);
                    txt5.setText(countryCode);

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            float bitcoinRate = Float.parseFloat(currency);
                            int bitcoin = 1;
                            double total;

                            String value2 = editText.getText().toString();
                            double inputAmount = Float.parseFloat(value2);
                            total = (inputAmount * bitcoin)/bitcoinRate;

                            convertedTxt.setText(String.format(Locale.getDefault(),"%.2f", total));
                        }
                    });
                }

            }
            if (data.equals("ethereum")){

                Bundle bundle = getIntent().getBundleExtra("bit");
                if (bundle==null){
                    finish();
                }else {
                    String page = bundle.getString("EthIntent");
                    String country = bundle.getString("country");
                    String countryCode = bundle.getString("countryCode");
                    final String currency = bundle.getString("currency");

                    txt1.setText(page);
                    txt2.setText(country);
                    txt3.setText(currency);
                    txt4.setText(page);
                    txt5.setText(countryCode);

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            float ethereumRate = Float.parseFloat(currency);
                            int ethereum = 1;
                            double total;

                            String value2 = editText.getText().toString();
                            double inputAmount = Float.parseFloat(value2);
                            total = (inputAmount * ethereum)/ethereumRate;

                            convertedTxt.setText(String.format(Locale.getDefault(),"%.2f", total));
                        }
                    });

                }
            }
        }

    }
    private Intent shareForecastIntent(){
        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("Text/plain")
                .setText("Check out this conversion rate")
                .getIntent();
        return shareIntent;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        menuItem.setIntent(shareForecastIntent());
        return true;

    }


}

