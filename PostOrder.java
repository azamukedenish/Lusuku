package com.example.bifam.lusuku;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.List;

public class PostOrder extends Activity {
    Button submit;
    OrderDbHandler db;

    static EditText pcontact, pproducename, pquantity, pndate, podate, punitprice;
    static String Contact, ProduceName, Quantity, Ndate, Odate, UnitPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_order);

        submit = (Button) findViewById(R.id.postsubmit);
        db = new OrderDbHandler(this);

        pcontact = (EditText) findViewById(R.id.postcontact);
        pproducename = (EditText) findViewById(R.id.postproduce);
        pquantity = (EditText) findViewById(R.id.postquantity);
        pndate = (EditText) findViewById(R.id.postndate);
        podate = (EditText) findViewById(R.id.postodate);
        punitprice = (EditText) findViewById(R.id.postunitprice);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Contact = pcontact.getText().toString();
                ProduceName = pproducename.getText().toString();
                Quantity = pquantity.getText().toString();
                Ndate = pndate.getText().toString();
                Odate = podate.getText().toString();
                UnitPrice = punitprice.getText().toString();

                // Inserting Contacts
                Log.d("Insert: ", "Inserting ..");
                db.addOrder(new Order(Contact, ProduceName, Quantity, Ndate, Odate, UnitPrice));
                pcontact.setText("");
                pproducename.setText("");
                pquantity.setText("");
                pndate.setText("");
                podate.setText("");
                punitprice.setText("");
            }
        });
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Order> order = db.getAllOrders();

        for (Order cn : order) {
            String log = "Id: " + cn.get_id() + " ,Contact: " + cn.get_phonenumber() + " ,ProduceName: " + cn.get_producename() + " ,Quantity: " + cn.get_quntity() + " ,Ndate: " + cn.get_ndate() + " ,Odate: " + cn.get_odate() + " ,UnitPrice: " + cn.get_unitprice();
            // Writing Contacts to log
            Log.d("Order: ", log);
        }
    }
}
