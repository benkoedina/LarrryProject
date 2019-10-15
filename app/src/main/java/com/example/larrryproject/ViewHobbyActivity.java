package com.example.larrryproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ViewHobbyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_hobby);

        SharedPreferences sharedPref = getSharedPreferences("MyHobby",MODE_PRIVATE);
        String hobby = sharedPref.getString("hobbies","DEFAULT");



       TextView tv_hobby = (TextView)findViewById(R.id.hobby);
       tv_hobby.setText(hobby);
    }

}
