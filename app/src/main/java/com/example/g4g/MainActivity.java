package com.example.g4g;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnHomeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnHomeActivity = (Button)findViewById(R.id.btnStart);
        btnHomeActivity.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.btnStart){
            Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(homeIntent);
        }
    }
}