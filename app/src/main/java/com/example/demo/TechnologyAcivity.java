package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.model.Technology;
import com.example.demo.model.TechnologyAdapter;

public class TechnologyAcivity extends AppCompatActivity {

    private ListView listView;
    TechnologyAdapter adapter;
    private Technology[] list;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technology_acivity);
        listView = findViewById((R.id.view));
        tv = findViewById(R.id.tv);
        registerForContextMenu(tv);

        initData();
       adapter = new TechnologyAdapter(this,list);
       listView.setAdapter(adapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               for (int i=0;i< listView.getAdapter().getCount(); i++){
                   listView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
               }
               listView.getChildAt(position).setBackgroundColor(Color.YELLOW);
               Technology t = adapter.getItem(position);
               Toast.makeText(getApplicationContext(),t.getName(), Toast.LENGTH_SHORT).show();
           }
       });
    }

    private void initData() {
        Integer[] imgs ={R.drawable.img,R.drawable.img_1,R.drawable.gg,R.drawable.face};
        String[] names ={"Android","Ios","Blackberry","Window mobile"};
        String[] subs ={"sub Android","sub Ios","sub Blackberry","sub Window mobile"};
        String[] descs ={"MT Android","Mt Ios","mt Blackberry","mt Window mobile"};
        list = new Technology[imgs.length];
        for (int i=0; i<list.length; i++){
            list[i] = new Technology(imgs[i],names[i],subs[i],descs[i]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mFile:
                Toast.makeText(this,"File", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mExit:
                System.exit(0);
                break;
            case R.id.mEmail:
                Toast.makeText(this,"Email", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mPhone:
                Toast.makeText(this,"Phone", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.color_menu,menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mRed:tv.setTextColor(Color.RED);
                break;
            case R.id.mBlue:tv.setTextColor(Color.BLUE);
                break;
            case R.id.mGreen:tv.setTextColor(Color.GREEN);
                break;
        };

        return super.onContextItemSelected(item);
    }
}