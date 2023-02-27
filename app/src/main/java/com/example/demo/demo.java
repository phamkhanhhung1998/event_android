package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class demo extends AppCompatActivity {

    private EditText e1, e2;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n1 = e1.getText().toString();
                String n2 = e2.getText().toString();
                if(n1.equalsIgnoreCase("hung") && n2.equals("hung")){
                    Toast.makeText(getApplicationContext(),"Nhập đúng",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(),"Nhập sai",Toast.LENGTH_LONG).show();

            }
        });

    }

    private void initView() {
        e1= findViewById(R.id.edit1);
        e2= findViewById(R.id.edit2);
        btn = findViewById(R.id.login);

    }
}