package com.example.bifam.lusuku;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FarmerList extends Activity {

    ListView listView ;
    FarmerDBHandler db;
    List<String> FarmerList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_list);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.listFarmer);

        db = new FarmerDBHandler(getApplicationContext());
        List<Farmer> farmer = db.getAllFarmer();

        for (Farmer cn : farmer) {
            FarmerList.add(String.valueOf(cn.get_id()));
            FarmerList.add(cn.get_name());
            FarmerList.add(cn.get_gender());
            FarmerList.add(cn.get_phonenumber());
            FarmerList.add(cn.get_district());
            FarmerList.add(cn.get_subcounty());
            FarmerList.add(cn.get_parish());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,  FarmerList);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();
            }
        });
    }



}
