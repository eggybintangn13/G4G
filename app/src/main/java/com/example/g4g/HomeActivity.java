package com.example.g4g;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private GearAdapter adapter;
    private String[] menuName;
    private TypedArray menuPhoto;
    private ArrayList<Gear> gears;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        ListView listView = findViewById(R.id.menu_list);
        adapter = new GearAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Toast.makeText(HomeActivity.this, gears.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepare() {
        menuName = getResources().getStringArray(R.array.menu_name);
        menuPhoto = getResources().obtainTypedArray(R.array.menu_photo);
    }

    private void addItem(){
        gears = new ArrayList<>();

        for (int i = 0; i < menuName.length; i++) {
            Gear gear = new Gear();
            gear.setPhoto(menuPhoto.getResourceId(i, -1));
            gear.setName(menuName[i]);
            gears.add(gear);
        }

        adapter.setGears(gears);
    }
}