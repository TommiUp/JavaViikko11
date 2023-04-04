package com.example.javaviikko11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private EditText productName;
    private EditText productNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        productName = findViewById(R.id.productNameText);
        productNotes = findViewById(R.id.productNotesText);
    }
    public void addOstos(View view) {
        String addProductName = productName.getText().toString();
        String addProductNotes = productNotes.getText().toString();
        Product newProduct = new Product(addProductName, addProductNotes);
        Storage.getInstance().addProduct(newProduct);
        Storage.getInstance().saveProducts(this);
        finish();
    }
}