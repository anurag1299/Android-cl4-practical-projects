package com.example.practical_5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        String message = "Order: " +
                intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.order_textview);
        textView.setText(message);
    }

    public void PlaceOrder(View view) {
        AlertDialog.Builder placeAlert = new AlertDialog.Builder(OrderActivity.this);

        placeAlert.setTitle("Do you want to place order?");
        placeAlert.setMessage("Press Ok to continue, or Cancel to stop");

        placeAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                
                //Toast.makeText(getApplicationContext(),"Pressed Ok", Toast.LENGTH_SHORT).show();
            }
        });

        placeAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Pressed Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        placeAlert.show();
    }
}
