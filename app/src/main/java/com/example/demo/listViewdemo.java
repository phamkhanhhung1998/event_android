package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class listViewdemo extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_viewdemo);
        listView = findViewById(R.id.view);
        initListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selection = adapter.getItem(position);
                Toast.makeText(getApplicationContext(),selection, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initListView() {
        String[] list = getResources().getStringArray(R.array.tech);
         adapter = new ArrayAdapter<>(this,R.layout.item,list);
        listView.setAdapter(adapter);

    }

}