package com.example.bifam.lusuku;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class PostComment extends Activity {
    Button submit;
    CommentDBHandler db;

    static EditText pcontact, psubject, pcomment;
    static String Contact, Subject, Comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_comment);

        submit = (Button) findViewById(R.id.csubmit);
        db = new CommentDBHandler(this);

        pcontact = (EditText) findViewById(R.id.cphone);
        psubject = (EditText) findViewById(R.id.csubject);
        pcomment = (EditText) findViewById(R.id.ccomment);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Contact = pcontact.getText().toString();
                Subject = psubject.getText().toString();
                Comment = pcomment.getText().toString();
                // Inserting Contacts
                Log.d("Insert: ", "Inserting ..");
                db.addComment(new Comment(Contact, Subject, Comment));
                pcontact.setText("");
                psubject.setText("");
                pcomment.setText("");
            }
        });
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Comment> comment = db.getAllComment();

        for (Comment cn : comment) {
            String log = "Id: " + cn.get_id() + " ,Contact: " + cn.get_phonenumber() + " ,Subject: " + cn.get_subject() + " ,Comment: " + cn.get_comment();
            // Writing Contacts to log
            Log.d("Comment: ", log);
        }
    }
}
