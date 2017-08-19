package com.example.bifam.lusuku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BLogin extends AppCompatActivity {
    Button button;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogin);

        button = (Button)findViewById(R.id.blogin);
        button1 = (Button)findViewById(R.id.bregister);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BLogin.this, StartSelling.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Login Clicked",Toast.LENGTH_SHORT).show();
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BLogin.this,PostBuyers.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Register Clicked",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
