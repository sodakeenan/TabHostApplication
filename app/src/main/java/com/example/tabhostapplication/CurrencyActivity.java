package com.example.tabhostapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class CurrencyActivity extends ActionBarActivity {

    //Button computeCurrency;

    EditText dollarsEditBox,
            eurosEditBox,
            uahEditBox;

    TextView usdToUahView,
            eurosToUahView,
            uahToPoundsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_currency);

        dollarsEditBox = (EditText) findViewById(R.id.dollarsEditBox);
        eurosEditBox = (EditText) findViewById(R.id.eurosEditBox);
        uahEditBox = (EditText) findViewById(R.id.uahEditBox);

        usdToUahView = (TextView) findViewById(R.id.usdToUahView);
        eurosToUahView = (TextView) findViewById(R.id.eurosToUahView);
        uahToPoundsView = (TextView) findViewById(R.id.uahToPoundsView);
    }

    public void computeCurrencyOnClick(View view)
    {
        usdToUahView.setText(
                getUSD_UAH(
                        dollarsEditBox.getText().toString()
                )
        );

        eurosToUahView.setText(
                getEUR_UAH(
                        eurosEditBox.getText().toString()
                )
        );

        uahToPoundsView.setText(
                getUAH_GBP(
                        uahEditBox.getText().toString()
                )
        );
    }

    final double USD_UAH_COURSE = 21.01;
    final double EUR_UAH_COURSE = 23.32;
    final double UAH_GBP_COURSE = 1 / 32.83;

    String getUSD_UAH(String USD_string)
    {
        if(USD_string.isEmpty())
            return "";

        double USD = Double.parseDouble(USD_string);
        return Double.toString(USD * USD_UAH_COURSE);
    }

    String getEUR_UAH(String EUR_string)
    {
        if(EUR_string.isEmpty())
            return "";

        double EUR = Double.parseDouble(EUR_string);
        return Double.toString(EUR * EUR_UAH_COURSE);
    }

    // GBP from UAH
    String getUAH_GBP(String UAH_string)
    {
        if(UAH_string.isEmpty())
            return "";

        double UAH = Double.parseDouble(UAH_string);
        return Double.toString(UAH * UAH_GBP_COURSE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_currency, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
