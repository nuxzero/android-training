package me.cafecode.simpleuserinterface;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO Here
        final EditText messageInput = (EditText) findViewById(R.id.edit_message);

        Button sendMessageButton = (Button) findViewById(R.id.button_send);
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = messageInput.getText().toString();

                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                intent.putExtra("message", message);
                startActivity(intent);
            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        CheckBox studentCheckBox = (CheckBox) findViewById(R.id.checkbox_student);
        studentCheckBox.setOnClickListener(this);

        RadioButton maleRadioButton = (RadioButton) findViewById(R.id.radio_male);
        maleRadioButton.setOnClickListener(this);

        RadioButton femaleRadioButton = (RadioButton) findViewById(R.id.radio_female);
        femaleRadioButton.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id == R.id.button) {
            Toast.makeText(this, "Click button", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.checkbox_student) {
            CheckBox checkBox = (CheckBox) v;
            if (checkBox.isChecked()) {
                Toast.makeText(this, "Your are student", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Your are not student", Toast.LENGTH_SHORT).show();
            }
        } else if (v instanceof RadioButton) {
            boolean checked = ((RadioButton) v).isChecked();
            if (checked) {
                if (id == R.id.radio_male) {
                    Toast.makeText(this, "Male", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.radio_female) {
                    Toast.makeText(this, "Female", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
