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

public class PostList extends Activity {

    ListView listView ;
    DatabaseHandler db;
    List<String> Poslist = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        db = new DatabaseHandler(getApplicationContext());
        List<Post> posts = db.getAllPosts();

        for (Post cn : posts) {
            Poslist.add(String.valueOf(cn.get_id()));
            Poslist.add(cn.get_phonenumber());
            Poslist.add(cn.get_postname());
            Poslist.add(cn.get_featureone());
            Poslist.add(cn.get_featuretwo());
            Poslist.add(cn.get_featurethree());
            Poslist.add(cn.get_description());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,  Poslist);


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

