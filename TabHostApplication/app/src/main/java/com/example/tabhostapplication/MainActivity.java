package com.example.tabhostapplication;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;


public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();
        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("weight");
        tabSpec.setIndicator("����");
        tabSpec.setContent(new Intent(this, WeightActivity.class));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("time");
        tabSpec.setIndicator("���");
        tabSpec.setContent(new Intent(this, TimeActivity.class));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("currency");
        tabSpec.setIndicator("������");
        tabSpec.setContent(new Intent(this, CurrencyActivity.class));
        tabHost.addTab(tabSpec);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
