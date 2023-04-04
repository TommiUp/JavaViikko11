package com.example.javaviikko11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private Storage storage;
    private Context context;
    private RecyclerView recyclerView;
    private ProductListAdapter adapter;
    private ImageView imgCalendar, imgABC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvProductList);
        storage = Storage.getInstance();
        context = this;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductListAdapter(getApplicationContext(), storage.getProducts());
        recyclerView.setAdapter(adapter);
        imgCalendar = findViewById(R.id.imageCalendar);
        imgABC = findViewById(R.id.imageABC);
        imgCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(storage.getProducts(), (product1, product2) -> {
                    int id1 = product1.getId();
                    int id2 = product2.getId();
                    return Integer.compare(id1, id2);
                });
                adapter.notifyDataSetChanged();
            }
        });

        imgABC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(storage.getProducts(), (product1, product2) -> product1.getProductName().compareTo(product2.getProductName()));
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        adapter.setProducts(storage.getProducts());
        adapter.notifyDataSetChanged();
    }
    public void switchToAddProduct(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }
}