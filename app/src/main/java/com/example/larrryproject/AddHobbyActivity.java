package com.example.larrryproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddHobbyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hobby);

        Button bt_view_hobby = (Button)findViewById(R.id.b_view_hobby);
        Button bt_add_hobby = (Button)findViewById(R.id.b_add_hobby);
        final List<String> listOfHobbies = new ArrayList<String>();

        bt_view_hobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("MyHobby",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("hobbies", TextUtils.join("\n", listOfHobbies));
                editor.commit();
                Intent intent = new Intent(AddHobbyActivity.this,ViewHobbyActivity.class);
                startActivity(intent);
            }
        });

        bt_add_hobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText et_add_hobby = (EditText)findViewById(R.id.et_hobby_name);
                String hobby = et_add_hobby.getText().toString();
                listOfHobbies.add(hobby);

              /*  EditText et_add_hobby = (EditText)findViewById(R.id.et_hobby_name);

                String hobby = et_add_hobby.getText().toString();
                SharedPreferences sharedPref = getSharedPreferences("MyHobby",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("hobby",hobby);
                editor.commit();*/
                Toast.makeText(AddHobbyActivity.this,"You add a new Hobby", Toast.LENGTH_LONG).show();
            }
        });

    }
}
