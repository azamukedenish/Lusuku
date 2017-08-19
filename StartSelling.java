package com.example.bifam.lusuku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StartSelling extends AppCompatActivity {
    Button button;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_selling);

        button = (Button)findViewById(R.id.button);
        text = (TextView)findViewById(R.id.textView5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartSelling.this, PostProduce.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Post Produce Clicked",Toast.LENGTH_SHORT).show();
            }
        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartSelling.this, PostFarmer.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Farmer Registration Clicked",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
