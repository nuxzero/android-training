package com.example.android.actionbarcompat.basic;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_main);

        // TODO Set ToolBar into Support Action Bar

        // TODO Add custom view into Action Bar

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate our menu from the resources by using the menu inflater.
        getMenuInflater().inflate(R.menu.main, menu);

        // TODO Add menu item here


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_refresh:
                // Here we might start a background refresh task
                return true;

            case R.id.menu_location:
                // Here we might call LocationManager.requestLocationUpdates()
                return true;

            case R.id.menu_settings:
                // Here we would open up our settings activity
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
