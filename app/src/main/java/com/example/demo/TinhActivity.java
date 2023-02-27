package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TinhActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView kq;
    private EditText edit1, edit2;
    private Button btAdd,btSub;
    private Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh);
        initView();
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nn1 = edit1.getText().toString();
        String nn2 = edit2.getText().toString();
        double n1,n2;
        try {
            n1 = Double.parseDouble(nn1);
            n2 = Double.parseDouble(nn2);
            String kk = tinhtoan(n1,n2,"+");
            kq.setText(kk);
            Toast.makeText(getApplicationContext(),kk,Toast.LENGTH_LONG).show();
        }catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Nhập 2 số",Toast.LENGTH_LONG).show();
        }
            }
        });
        btSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nn1 = edit1.getText().toString();
                String nn2 = edit2.getText().toString();
                double n1,n2;
                try {
                    n1 = Double.parseDouble(nn1);
                    n2 = Double.parseDouble(nn2);
                    String kk = tinhtoan(n1,n2,"-");
                    kq.setText(kk);
                    Toast.makeText(getApplicationContext(),kk,Toast.LENGTH_LONG).show();
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Nhập 2 số",Toast.LENGTH_LONG).show();
                }
            }
        });
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String nn1 = edit1.getText().toString();
                String nn2 = edit2.getText().toString();
                double n1,n2;
                try {
                    n1 = Double.parseDouble(nn1);
                    n2 = Double.parseDouble(nn2);
                    String p=sp.getSelectedItem().toString();
                    String kk = tinhtoan(n1,n2,p);
                    kq.setText(kk);
                    Toast.makeText(getApplicationContext(),kk,Toast.LENGTH_LONG).show();
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Nhập 2 số",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initView() {
        kq = findViewById(R.id.kq);
        edit1 = findViewById(R.id.e1);
        edit2 = findViewById(R.id.e2);
        sp = findViewById(R.id.sp);
        btAdd = findViewById(R.id.btAdd);
        btSub = findViewById(R.id.btSub);
        String[] st = getResources().getStringArray(R.array.phep);
        ArrayAdapter <String> adapter = new ArrayAdapter<>(this,R.layout.item,st);
        sp.setAdapter(adapter);
    }

//    public void add(View v){
//        String nn1 = edit1.getText().toString();
//        String nn2 = edit2.getText().toString();
//        double n1,n2;
//        try {
//            n1 = Double.parseDouble(nn1);
//            n2 = Double.parseDouble(nn2);
//            String kk = tinhtoan(n1,n2,"+");
//            kq.setText(kk);
//            Toast.makeText(this,kk,Toast.LENGTH_LONG).show();
//        }catch (NumberFormatException e){
//
//        }

//    }
    private String tinhtoan(double x, double y, String p){
        String s="";
        switch (p){
            case "+": s= "Tổng: " +(x+y);
                break;

            case "-": s= "Hiệu : " +(x-y);
                break;
            case "x": s= "Tích : " +(x*y);
                break;
            case ":":
                if(y==0)
                    s="Không chia cho 0";
                else
                    s= "Thương: " +(x/y);
                break;
        }

        return s;

    }

    @Override
    public void onClick(View view) {

    }
}