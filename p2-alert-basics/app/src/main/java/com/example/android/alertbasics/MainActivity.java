package com.example.android.alertbasics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void logConsole(View view) {
        // TODO Log console here

    }


    public void simpleToastAlert(View view) {
        // TODO Simple Toast here

    }

    public void positionToastAlert(View view) {
        // TODO Position Toast here

    }

    public void customToastAlert(View view) {
        // TODO Custom Toast here

    }

    public void simpleAlertDialog(View view) {
        // TODO... Create simple AlertDialog here

    }

    public void progressDialog(View view) {
        // TODO Progress Dialog here

    }

    public void listDialog(View view) {
        // TODO... List dialog

    }

    public void customDialog(View view) {
        // TODO Custom Dialog here

    }

    public void datePickerDialog(View view) {
        // TODO Date Picker Dialog here

    }
}
