package com.example.bifam.lusuku;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.List;


public class PostProduce extends Activity {
    Button btn, submit;
    private static final int CAMERA_REQUEST = 123;
    ImageView imageView;
    Button viewposts;
    DatabaseHandler db;

    static EditText pcontact, ppostname, pfeatureone, pfeaturetwo, pfeaturethree, pdescription;
    static String Contact, PostName, FeatureOne, FeatureTwo, FeatureThree, Description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_produce);

        btn = (Button) findViewById(R.id.button8);
        viewposts = (Button) findViewById(R.id.button9);
        imageView = (ImageView) findViewById(R.id.idImageView);
        submit = (Button) findViewById(R.id.post);

        db = new DatabaseHandler(this);

        pcontact = (EditText) findViewById(R.id.contactone);
        ppostname = (EditText) findViewById(R.id.postname);
        pfeatureone = (EditText) findViewById(R.id.featureone);
        pfeaturetwo = (EditText) findViewById(R.id.featuretwo);
        pfeaturethree = (EditText) findViewById(R.id.featurethree);
        pdescription = (EditText) findViewById(R.id.description);


        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Contact = pcontact.getText().toString();
                PostName = ppostname.getText().toString();
                FeatureOne = pfeatureone.getText().toString();
                FeatureTwo = pfeaturetwo.getText().toString();
                FeatureThree = pfeaturethree.getText().toString();
                Description = pdescription.getText().toString();

                // Inserting Contacts
                Log.d("Insert: ", "Inserting ..");
                db.addPost(new Post(Contact, PostName, FeatureOne, FeatureTwo, FeatureThree, Description));
                pcontact.setText("");
                ppostname.setText("");
                pfeatureone.setText("");
                pfeaturetwo.setText("");
                pfeaturethree.setText("");
                pdescription.setText("");
            }
        });
        viewposts.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent viewlist = new Intent(PostProduce.this, PostList.class);
                PostProduce.this.startActivity(viewlist);
                //finish();

            }
        });

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Post> post = db.getAllPosts();

        for (Post cn : post) {
            String log = "Id: " + cn.get_id() + " ,Contact: " + cn.get_phonenumber() + " ,PostName: " + cn.get_postname() + " ,FeatureOne: " + cn.get_featureone() + " ,FeatureTwo: " + cn.get_featuretwo() + " ,FeatureThree: " + cn.get_featurethree() + " ,Description: " + cn.get_description();
            // Writing Contacts to log
            Log.d("Contact: ", log);

        }

    }

    public void btnClick(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {

            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);

        }
    }

}
