package com.example.android.googleplaces;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private boolean showMaps = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);

        // Setup custom ActionBar
        View customActionBarView = LayoutInflater.from(this).inflate(R.layout.custom_actionbar, null);
        actionBar.setCustomView(customActionBarView);

        // TODO: Call switchFragment

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_switch) {

            // TODO: Switch menu icon

            // Switch fragment between RecyclerFragment and MapsFragment
            switchFragment();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void switchFragment(){
        if (showMaps) {
            showMaps = false;
            // Replace MapsFragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment, new MapsFragment())
                    .commit();
        } else {
            showMaps = true;
            // Replace MapsFragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment, new RecyclerFragment())
                    .commit();
        }
    }
}
