package com.example.larrryproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = (EditText)findViewById(R.id.et_name);
        EditText email = (EditText)findViewById(R.id.et_email);
        EditText password = (EditText)findViewById(R.id.et_passw);
        Button dateButton = (Button)findViewById(R.id.b_date);
        CheckBox checkBox = (CheckBox)findViewById(R.id.check);
        Button loginButton = (Button)findViewById(R.id.b_login);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        TextView birthDate = (TextView)findViewById(R.id.tv_birthD);
                        birthDate.setText(day + "/" + month + "/" + year);
                        Toast.makeText(MainActivity.this,"You set the date!", Toast.LENGTH_LONG).show();

                    }
                }, year, month, dayOfMonth);

                datePickerDialog.show();


            }
        });

       boolean checked = checkBox.isChecked();
        if(checked)
        {
            String nameS = name.getText().toString();
            String emailS = email.getText().toString();
            String passwS = password.getText().toString();
            SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("name",nameS);
            editor.putString("email",emailS);
            editor.putString("passW",passwS);
            editor.commit();
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,AddHobbyActivity.class);
                startActivity(intent);
            }
        });

    }

}
