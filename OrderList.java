package com.example.bifam.lusuku;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OrderList extends Activity {

    ListView listView ;
    OrderDbHandler db;
    List<String> OrderList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.listOrder);

        db = new OrderDbHandler(getApplicationContext());
        List<Order> orders = db.getAllOrders();

        for (Order cn : orders) {
            OrderList.add(String.valueOf(cn.get_id()));
            OrderList.add(cn.get_phonenumber());
            OrderList.add(cn.get_producename());
            OrderList.add(cn.get_quntity());
            OrderList.add(cn.get_ndate());
            OrderList.add(cn.get_odate());
            OrderList.add(cn.get_unitprice());

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,  OrderList);


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

