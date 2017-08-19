package com.example.bifam.lusuku;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class BuyerDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "buyerManager.db";

    public static final String TAG = "BuyerDBHandler";

    // Contacts table name
    private static final String TABLE_BUYER ="buyers";

    //buyerRegistration columns
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_CONTACT = "phone_number";
    private static final String KEY_DISTRICT = "district";

    //table postproduce


    //table buyers
    private static final String CREATE_BUYERS_TABLE = "CREATE TABLE " + TABLE_BUYER + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT NOT NULL,"
            + KEY_EMAIL + " TEXT NOT NULL," + KEY_GENDER + " TEXT NOT NULL,"
            + KEY_CONTACT + " TEXT NOT NULL," + KEY_DISTRICT + " TEXT NOT NULL" + ")";

    public BuyerDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BUYERS_TABLE);

    }
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Upgrading the database from version " + oldVersion + " to "+ newVersion);
        // clear all data

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUYER);

        // recreate the tables
        onCreate(db);
    }

    public BuyerDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    // Getting single post
    Buyers getBuyer(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_BUYER, new String[]{KEY_ID,
                        KEY_NAME, KEY_EMAIL, KEY_GENDER, KEY_CONTACT, KEY_DISTRICT}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Buyers buyers;
        buyers = new Buyers(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
        // return contact
        return buyers;
    }

    void addBuyers(Buyers buyers) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, buyers.get_name());
        values.put(KEY_EMAIL, buyers.get_email());
        values.put(KEY_GENDER, buyers.get_gender());
        values.put(KEY_CONTACT, buyers.get_phoneNumber());
        values.put(KEY_DISTRICT, buyers.get_district());

        // Inserting Row
        db.insert(TABLE_BUYER, null, values);
        db.close(); // Closing database connection
    }

    // Getting single post
    Buyers getBuyers(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_BUYER, new String[]{KEY_ID,
                        KEY_NAME, KEY_EMAIL, KEY_GENDER, KEY_CONTACT, KEY_DISTRICT}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Buyers buyers = new Buyers(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
        // return contact
        return buyers;
    }

    // Getting All Buyers
    public List<Buyers> getAllBuyers() {
        List<Buyers> buyersList = new ArrayList<Buyers>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_BUYER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor;
        cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Buyers buyers = new Buyers();
                buyers.set_id(Integer.parseInt(cursor.getString(0)));
                buyers.set_name(cursor.getString(1));
                buyers.set_email(cursor.getString(2));
                buyers.set_gender(cursor.getString(3));
                buyers.set_phoneNumber(cursor.getString(4));
                buyers.set_district(cursor.getString(5));

                // Adding contact to list
                buyersList.add(buyers);
            } while (cursor.moveToNext());
        }

        // return contact list
        return buyersList;
    }
    // Updating single buyer
    public int updateBuyers(Buyers buyers) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, buyers.get_name());
        values.put(KEY_EMAIL, buyers.get_email());
        values.put(KEY_GENDER, buyers.get_gender());
        values.put(KEY_CONTACT, buyers.get_phoneNumber());
        values.put(KEY_DISTRICT, buyers.get_district());

        // updating row
        return db.update(TABLE_BUYER, values, KEY_ID + " = ?",
                new String[]{String.valueOf(buyers.get_id())});
    }

    // Deleting single post
    public void deleteBuyer(Buyers buyers) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BUYER, KEY_ID + " = ?",
                new String[]{String.valueOf(buyers.get_id())});
        db.close();
    }

    // Getting buyers Count
    public int getBuyersCount() {
        String countQuery = "SELECT  * FROM " + TABLE_BUYER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}
