package com.example.bifam.lusuku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.List;

public class PostBuyers extends Activity {

    Button submit;
    BuyerDBHandler db;

    static EditText pname, pemail, pgender, pphonenumber, pdistrict;
    static String Name, Email, Gender, Phonenumber, District;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_buyers);

        submit = (Button) findViewById(R.id.postBuyerone);
        db = new BuyerDBHandler(this);

        pname = (EditText) findViewById(R.id.name);
        pemail = (EditText) findViewById(R.id.email);
        pgender = (EditText) findViewById(R.id.gender);
        pphonenumber = (EditText) findViewById(R.id.buyercontact);
        pdistrict = (EditText) findViewById(R.id.district);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Name = pname.getText().toString();
                Email = pemail.getText().toString();
                Gender = pgender.getText().toString();
                Phonenumber = pphonenumber.getText().toString();
                District = pdistrict.getText().toString();


                // Inserting Contacts
                Log.d("Insert: ", "Inserting ..");
                db.addBuyers(new Buyers(Name, Email, Gender, Phonenumber, District));
                pname.setText("");
                pemail.setText("");
                pgender.setText("");
                pphonenumber.setText("");
                pdistrict.setText("");
            }
        });

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Buyers> buyers = db.getAllBuyers();

        for (Buyers cn : buyers) {
            String log = "Id: " + cn.get_id() + " ,Name: " + cn.get_name() + " ,Email: " + cn.get_email() + " ,Gender: " + cn.get_gender() + " ,Phonenumber: " + cn.get_phoneNumber() + " ,District: " + cn.get_district();
            // Writing Contacts to log
            Log.d("Buyer: ", log);
        }

    }

}
