package com.example.bifam.lusuku;

import android.content.ContentValues;
import android.util.Log;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    public static final String TAG = "DatabaseHandler";

    // Database Name
    private static final String DATABASE_NAME = "postManager.db";

    // Contacts table name
    private static final String TABLE_POST = "posts";

    // postproduce Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_CONTACT = "phone_number";
    private static final String KEY_POSTNAME = "post_name";
    private static final String KEY_FEATUREONE = "feature_one";
    private static final String KEY_FEATURETWO = "feature_two";
    private static final String KEY_FEATURETHREE = "feature_three";
    private static final String KEY_DESCRIPTION = "desc";

    private static final String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_POST + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_CONTACT + " TEXT NOT NULL,"
            + KEY_POSTNAME + " TEXT NOT NULL," + KEY_FEATUREONE + " TEXT NOT NULL,"
            + KEY_FEATURETWO + " TEXT NOT NULL," + KEY_FEATURETHREE + " TEXT NOT NULL," + KEY_DESCRIPTION + " TEXT NOT NULL" + ")";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Upgrading the database from version " + oldVersion + " to " + newVersion);
        // clear all data
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POST);
        // recreate the tables
        onCreate(db);
    }

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    //************************postproduce methods****************//
    // Adding new contact
    void addPost(Post post) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CONTACT, post.get_phonenumber());
        values.put(KEY_POSTNAME, post.get_postname());
        values.put(KEY_FEATUREONE, post.get_featureone());
        values.put(KEY_FEATURETWO, post.get_featuretwo());
        values.put(KEY_FEATURETHREE, post.get_featurethree());
        values.put(KEY_DESCRIPTION, post.get_description());

        // Inserting Row
        db.insert(TABLE_POST, null, values);
        db.close(); // Closing database connection
    }

    // Getting single post
    Post getPost(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor;
        cursor = db.query(TABLE_POST, new String[]{KEY_ID,
                        KEY_CONTACT, KEY_POSTNAME, KEY_FEATUREONE, KEY_FEATURETWO, KEY_FEATURETHREE, KEY_DESCRIPTION}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Post post = new Post(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
        // return contact
        return post;
    }

    // Getting All Contacts
    public List<Post> getAllPosts() {
        List<Post> postList = new ArrayList<Post>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_POST;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Post post = new Post();
                post.set_id(Integer.parseInt(cursor.getString(0)));
                post.set_phonenumber(cursor.getString(1));
                post.set_postname(cursor.getString(2));
                post.set_featureone(cursor.getString(3));
                post.set_featuretwo(cursor.getString(4));
                post.set_featurethree(cursor.getString(5));
                post.set_description(cursor.getString(6));

                // Adding contact to list
                postList.add(post);
            } while (cursor.moveToNext());
        }

        // return contact list
        return postList;
    }

    // Updating single contact
    public int updateContact(Post post) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CONTACT, post.get_phonenumber());
        values.put(KEY_POSTNAME, post.get_postname());
        values.put(KEY_FEATUREONE, post.get_featureone());
        values.put(KEY_FEATURETWO, post.get_featuretwo());
        values.put(KEY_FEATURETHREE, post.get_featurethree());
        values.put(KEY_DESCRIPTION, post.get_description());

        // updating row
        return db.update(TABLE_POST, values, KEY_ID + " = ?",
                new String[]{String.valueOf(post.get_id())});
    }

    // Deleting single post
    public void deletePost(Post post) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_POST, KEY_ID + " = ?",
                new String[]{String.valueOf(post.get_id())});
        db.close();
    }

    // Getting post Count
    public int getPostCount() {
        String countQuery = "SELECT  * FROM " + TABLE_POST;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}