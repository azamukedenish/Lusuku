package com.example.bifam.lusuku;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class PostFarmer extends Activity {
    Button submit;
    FarmerDBHandler db;

    static EditText pname, pgender, pphonenumber, pdistrict, psubcounty, pparish;
    static String Name, Gender, Phonenumber, District, Subcounty, Parish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_farmer);

        submit = (Button) findViewById(R.id.fRegister);
        db = new FarmerDBHandler(this);

        pname = (EditText) findViewById(R.id.fname);
        pgender = (EditText) findViewById(R.id.fgender);
        pphonenumber = (EditText) findViewById(R.id.fphone);
        pdistrict = (EditText) findViewById(R.id.fdistrict);
        psubcounty = (EditText) findViewById(R.id.fsubcounty);
        pparish = (EditText) findViewById(R.id.fparish);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Name = pname.getText().toString();
                Gender = pgender.getText().toString();
                Phonenumber = pphonenumber.getText().toString();
                District = pdistrict.getText().toString();
                Subcounty = psubcounty.getText().toString();
                Parish = pparish.getText().toString();

                // Inserting Contacts
                Log.d("Insert: ", "Inserting ..");
                db.addFarmer(new Farmer(Name, Gender, Phonenumber, District, Subcounty, Parish));
                pname.setText("");
                pgender.setText("");
                pphonenumber.setText("");
                pdistrict.setText("");
                psubcounty.setText("");
                pparish.setText("");
            }
        });
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Farmer> farmer = db.getAllFarmer();

        for (Farmer cn : farmer) {
            String log = "Id: " + cn.get_id() + " ,Name: " + cn.get_name() + " ,Gender: " + cn.get_gender() + " ,Phonenumber: " + cn.get_phonenumber() + " ,District: " + cn.get_district() + " ,Subcounty: " + cn.get_subcounty() + " ,Parish: " + cn.get_parish();
            // Writing Contacts to log
            Log.d("Farmer: ", log);
        }
    }
}
