package com.example.tabhostapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class WeightActivity extends ActionBarActivity {

    Button computeWeight;

    EditText tonsEditBox,
            centnersEditBox,
            kilogramsEditBox;

    TextView centnersView,
            kilogramsView,
            gramsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_weight);

        tonsEditBox = (EditText) findViewById(R.id.tonsEditBox);
        centnersEditBox = (EditText) findViewById(R.id.centnersEditBox);
        kilogramsEditBox = (EditText) findViewById(R.id.kilogramsEditBox);

        centnersView = (TextView) findViewById(R.id.centnersView);
        kilogramsView = (TextView) findViewById(R.id.kilogramsView);
        gramsView = (TextView) findViewById(R.id.gramsView);
    }

    public void computeWeightOnClick(View view)
    {
        centnersView.setText(
                getCentnersString(
                        tonsEditBox.getText().toString()
                )
        );

        kilogramsView.setText(
                getKilogramsString(
                        centnersEditBox.getText().toString()
                )
        );

        gramsView.setText(
                getGramsString(
                        kilogramsEditBox.getText().toString()
                )
        );
    }

    String getCentnersString(String tonsString)
    {
        if(tonsString.isEmpty())
            return "";

        double tons = Double.parseDouble(tonsString);
        return Double.toString(tons * 10);
    }

    String getKilogramsString(String centnersString)
    {
        if(centnersString.isEmpty())
            return "";

        double centners = Double.parseDouble(centnersString);
        return Double.toString(centners * 100);
    }

    String getGramsString(String kilogramsString)
    {
        if(kilogramsString.isEmpty())
            return "";

        double kilograms = Double.parseDouble(kilogramsString);
        return Double.toString(kilograms * 1000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_weight, menu);
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
