package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

public class EventHandler02 extends AppCompatActivity {
    private CheckBox ck1,ck2,ck3,ck4,ck5,ck6,ck7,ck8;
    private RadioButton g1,g2;
    private RatingBar rt;
    private Spinner sp1,sp2;
    private TextView kq;
    private Button btht;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_handler02);
        initView();
        initSpiner();

        btht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ss ="Điện thoại đang dùng là: ";
                if(ck1.isChecked()) {
                    ss += ck1.getText()+",";
                }
                if(ck2.isChecked()) {
                    ss += ck2.getText()+",";
                }
                if(ck3.isChecked()) {
                    ss += ck3.getText()+",";
                }
                if(ss.endsWith(",")){
                    ss= ss.substring(0,ss.length()-1);
                }
                ss+= "\nGiới tính:";
                if(g1.isChecked()){
                    ss+= g1.getText();
                }
                if(g2.isChecked()){
                    ss+= g2.getText();
                }
                ss+="\nRating: " +rt.getRating();
                ss+="\n"+sp1.getSelectedItem().toString();
                ss+="\n" + sp2.getSelectedItem().toString();
                ss+="\nSở thích là: ";
                if(ck4.isChecked()) {
                    ss += ck4.getText()+",";
                }
                if(ck5.isChecked()) {
                    ss += ck5.getText()+",";
                }
                if(ck6.isChecked()) {
                    ss += ck6.getText()+",";
                }
                if(ck7.isChecked()) {
                    ss += ck7.getText()+",";
                }
                if(ck8.isChecked()) {
                    ss += ck8.getText()+",";
                }
                if(ss.endsWith(",")){
                    ss= ss.substring(0,ss.length()-1);
                }
                kq.setText(ss);

            }
        });
    }

    private void initSpiner() {
        String[] list ={"PTIT", "HUST", "KMA","NEU","FTU"};
        String[] list1= getResources().getStringArray(R.array.country);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item,list);
        sp2.setAdapter(adapter);
    }

    private void initView() {
        ck1 = findViewById(R.id.ck1);
        ck2 = findViewById(R.id.ck2);
        ck3 = findViewById(R.id.ck3);
        ck4 = findViewById(R.id.ck4);
        ck5 = findViewById(R.id.ck5);
        ck6 = findViewById(R.id.ck6);
        ck7 = findViewById(R.id.ck7);
        ck8 = findViewById(R.id.ck8);
        g1 = findViewById(R.id.male);
        g2 = findViewById(R.id.female);
        rt = findViewById(R.id.rating);
        btht= findViewById(R.id.submit);
        kq = findViewById(R.id.ht);
        sp1= findViewById(R.id.country);
        sp2 = findViewById(R.id.univer1);
    }
}