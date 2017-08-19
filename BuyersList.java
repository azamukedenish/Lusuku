package com.example.bifam.lusuku;

        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.Toast;
        import java.util.ArrayList;
        import java.util.List;

public class BuyersList extends Activity{

    ListView listView ;
    BuyerDBHandler db;
    List<String> BuyersList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyers_list);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.buyerList);

        db = new BuyerDBHandler(getApplicationContext());
        List<Buyers> buyers = db.getAllBuyers();

        for (Buyers cn : buyers) {
            BuyersList.add(String.valueOf(cn.get_id()));
            BuyersList.add(cn.get_name());
            BuyersList.add(cn.get_email());
            BuyersList.add(cn.get_gender());
            BuyersList.add(cn.get_phoneNumber());
            BuyersList.add(cn.get_district());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,  BuyersList);


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
