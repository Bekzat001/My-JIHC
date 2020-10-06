package com.example.myjihc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MebelActivity extends AppCompatActivity {

    TextView mebelName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mebel);
        mebelName = findViewById(R.id.mebelName);

        Intent intent = getIntent();
        String mName = intent.getStringExtra("mebelName");
        String mDesc = intent.getStringExtra("mebelDesc");
        String mCount = intent.getStringExtra("mebelCount");
        String mPrice = intent.getStringExtra("mebelPrice");

        mebelName.setText(mName+" "+mDesc+" "+mCount+"ш "+mPrice+"k");
    }
}