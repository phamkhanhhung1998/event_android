package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner sp,sp1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex1);

        sp = findViewById(R.id.univer1);
        String[] list ={"PTIT", "HUST", "KMA","NEU","FTU"};
        String[] list1= getResources().getStringArray(R.array.country);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item,list);
        sp.setAdapter(adapter);
    }

}