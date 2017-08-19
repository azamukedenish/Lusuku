package com.example.bifam.lusuku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Administrator extends AppCompatActivity {

    Button button;
    Button button1;
    Button button2;
    Button button3;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);

        button = (Button)findViewById(R.id.button4);
        button1 = (Button)findViewById(R.id.button5);
        button2 = (Button)findViewById(R.id.button7);
        button3 = (Button)findViewById(R.id.button11);
        button4 = (Button)findViewById(R.id.viewproduce);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Administrator.this, BuyersList.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Buyer Lists Clicked",Toast.LENGTH_SHORT).show();
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Administrator.this,FarmerList.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Farmer Lists Clicked",Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Administrator.this, OrderList.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Order Lists Clicked",Toast.LENGTH_SHORT).show();
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Administrator.this, CommentList.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"View Comments",Toast.LENGTH_SHORT).show();
            }
        });

        button4 = (Button) findViewById(R.id.viewproduce);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Administrator.this, PostList.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Comments Clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
