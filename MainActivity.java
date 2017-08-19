package com.example.bifam.lusuku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Button btn2;
    Button btn3;
    Button btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button1);
        btn3 = (Button)findViewById(R.id.button2);
        btn4 = (Button)findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, BLogin.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Buyer Clicked",Toast.LENGTH_SHORT).show();
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FarmerSelect.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Farmer Clicked",Toast.LENGTH_SHORT).show();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MarketPlace.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Enter Market Place",Toast.LENGTH_SHORT).show();
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AdminLogin.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Admin Login",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
