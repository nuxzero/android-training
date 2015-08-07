package com.example.android.alertbasics;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

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
        Log.i(TAG, "Send an INFO log message.");
        Log.v(TAG, "Send a VERBOSE log message.");
        Log.w(TAG, "Send a WARN log message.");
        Log.wtf(TAG, "What a Terrible Failure: Report a condition that should never happen.");
        Log.e(TAG, "Send an ERROR log message.");
        Log.d(TAG, "Send a DEBUG log message.");
    }


    public void simpleToastAlert(View view) {
        // TODO Simple Toast here
        Toast.makeText(this, "Simple Toast", Toast.LENGTH_SHORT).show();
    }

    public void positionToastAlert(View view) {
        // TODO Position Toast here
        Toast toast = Toast.makeText(this, "Position Toast", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
        toast.show();

    }

    public void customToastAlert(View view) {
        // TODO Custom Toast here
        View customToast = LayoutInflater.from(this).inflate(R.layout.custom_toast, null);
        Toast toast = Toast.makeText(this, "Position Toast", Toast.LENGTH_SHORT);
        toast.setView(customToast);
        toast.show();
    }

    public void simpleAlertDialog(View view) {
        // TODO... Create simple AlertDialog here
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Simple AlertDialog");
        dialog.setMessage("Hello world");
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.setNeutralButton("No thanks", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    public void progressDialog(View view) {
        // TODO Progress Dialog here
        ProgressDialog progressDialog = ProgressDialog.show(this, "Title", "Loading...", true, true);
        progressDialog.show();
    }

    public void listDialog(View view) {
        // TODO... List dialog
        final String[] colors = {"Red", "Green", "Yellow"};

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("List dialog");
        dialog.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, colors[which], Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    public void customDialog(View view) {
        // TODO Custom Dialog here
        View customView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null);
        final EditText nameInput = (EditText) customView.findViewById(R.id.input_message);

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Custom Dialog");
        dialog.setView(customView);
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String message = nameInput.getText().toString();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    public void datePickerDialog(View view) {
        // TODO Date Picker Dialog here
        Calendar calender = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Toast.makeText(MainActivity.this, dayOfMonth+"/"+monthOfYear+"/"+year, Toast.LENGTH_SHORT).show();

            }
        }, calender.get(Calendar.YEAR), calender.get(Calendar.MONTH), calender.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.setTitle("Date Picker");

        datePickerDialog.show();
    }
}
