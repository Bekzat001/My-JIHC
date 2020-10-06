package com.example.myjihc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FurnitureListAdapter furnitureListAdapter;
    ArrayList<Furniture> furnitureList;
    private RecyclerView.LayoutManager linearLayoutManager, gridLayoutManager;

    Button btnChange;
    boolean layoutType = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        initRecyclerItemClick();
    }
    public void initRecyclerItemClick() {
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, final int pos) {
                        Intent intent = new Intent(SecondActivity.this, MebelActivity.class);
                        intent.putExtra("mebelName", furnitureList.get(pos).getTitle());
                        intent.putExtra("mebelDesc", furnitureList.get(pos).getDesc());
                        intent.putExtra("mebelCount", ""+furnitureList.get(pos).getCount());
                        intent.putExtra("mebelPrice", ""+furnitureList.get(pos).getPrice());
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Toast.makeText(SecondActivity.this, "onLongItemClick", Toast.LENGTH_SHORT).show();
                    }
                })
        );
    }
    public void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        btnChange = findViewById(R.id.btnChange);
        furnitureList = new ArrayList<>();

        furnitureList.add(new Furniture(R.drawable.jokondaoreh, "Джоконда", "5дв крем", 5, 350));
        furnitureList.add(new Furniture(R.drawable.log, "Роселла", "4дв крем", 4, 400));
        furnitureList.add(new Furniture(R.drawable.log, "Патрисия", "6дв крем", 3, 450));

        furnitureListAdapter = new FurnitureListAdapter(this, furnitureList);

        linearLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(furnitureListAdapter);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutType = !layoutType;

                if (layoutType) {
                    recyclerView.setLayoutManager(gridLayoutManager);
                    furnitureList.remove(0);
                } else {
                    recyclerView.setLayoutManager(linearLayoutManager);
                }
                furnitureListAdapter.notifyDataSetChanged();
            }
        });

    }
}
