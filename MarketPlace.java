package com.example.bifam.lusuku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class MarketPlace extends AppCompatActivity {


    Button button;
    Button button1; //GPS
    Button button2;
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_place);

        button = (Button) findViewById(R.id.farmerstrading);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MarketPlace.this, FarmersTrading.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"View Farmer Lists",Toast.LENGTH_SHORT).show();
            }
        });

        button2 = (Button) findViewById(R.id.placeorder);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MarketPlace.this, PostOrder.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Place Order Clicked",Toast.LENGTH_SHORT).show();
            }
        });

        button3 = (Button) findViewById(R.id.comments);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MarketPlace.this, PostComment.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Comments Clicked",Toast.LENGTH_SHORT).show();
            }
        });
        button1 = (Button) findViewById(R.id.search);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MarketPlace.this, MapsActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"View Farmer Lists",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
