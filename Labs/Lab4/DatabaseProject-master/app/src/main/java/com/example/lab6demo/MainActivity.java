package com.example.lab6demo;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView idView;
    EditText productBox;
    EditText skuBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idView = (TextView) findViewById(R.id.productID);
        productBox = (EditText) findViewById(R.id.productName);
        skuBox = (EditText) findViewById(R.id.productSku);
    }

    public void newProduct (View view) {

        int sku = Integer.parseInt(skuBox.getText().toString());

        Product product = new Product(productBox.getText().toString(), sku);

        // TODO: add to database
        MyDBHandler dbHandler = new MyDBHandler(this);
        dbHandler.addProduct(product);

        productBox.setText("");
        skuBox.setText("");

    }


    public void lookupProduct (View view) {

        // TODO: get from Database
        MyDBHandler dbHandler = new MyDBHandler(this);
        Product product = dbHandler.findProduct(productBox.getText().toString());

        if (product != null) {
            idView.setText(String.valueOf(product.getID()));
            skuBox.setText(String.valueOf(product.getSku()));
        } else {
            idView.setText("No Match Found");
        }
    }


    public void removeProduct (View view) {

        // TODO: remove from database
        MyDBHandler dbHandler = new MyDBHandler(this);
        boolean result = dbHandler.deleteProduct(productBox.getText().toString());

        if (result) {
            idView.setText("Record Deleted");
            productBox.setText("");
            skuBox.setText("");
        }
        else
            idView.setText("No Match Found");
    }

    public void about(View view) {
        Intent aboutIntent = new Intent(this, About.class);
        startActivity(aboutIntent);
    }
}