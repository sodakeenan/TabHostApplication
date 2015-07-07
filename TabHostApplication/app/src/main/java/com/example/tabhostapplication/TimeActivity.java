package com.example.tabhostapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class TimeActivity extends ActionBarActivity {

    Button computeTimeButton;

    EditText daysEditBox,
            hoursEditBox,
            minutesEditBox;

    TextView hoursView,
            minutesView,
            secondsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_time);

        daysEditBox = (EditText) findViewById(R.id.daysEditBox);
        hoursEditBox = (EditText) findViewById(R.id.hoursEditBox);
        minutesEditBox = (EditText) findViewById(R.id.minutesEditBox);

        hoursView = (TextView) findViewById(R.id.hoursView);
        minutesView = (TextView) findViewById(R.id.minutesView);
        secondsView = (TextView) findViewById(R.id.secondsView);
    }

    public void computeTimeOnClick(View view)
    {
        hoursView.setText(
                getHoursString(
                        daysEditBox.getText().toString()
                ));

        minutesView.setText(
                getMinutesString(
                        hoursEditBox.getText().toString()
                ));

        secondsView.setText(
                getSecondsString(
                        minutesEditBox.getText().toString()
                )
        );
    }

    String getHoursString(String daysString)
    {
        if(daysString.isEmpty())
            return "";

        double days = Double.parseDouble(daysString);
        //String hoursString = String.format()
        return Double.toString(days * 24);
    }

    String getMinutesString(String hoursString)
    {
        if(hoursString.isEmpty())
            return "";

        double hours = Double.parseDouble(hoursString);
        return Double.toString(hours * 60);
    }

    String getSecondsString(String minutesString)
    {
        if(minutesString.isEmpty())
            return "";

        double minutes = Double.parseDouble(minutesString);
        return Double.toString(minutes * 60);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_time, menu);
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
