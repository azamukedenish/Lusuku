package com.example.bifam.lusuku;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class FarmerDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "farmerManager.db";
    // Contacts table name
    private static final String TABLE_FARMER = "farmer";
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_CONTACT = "phonenumber";
    private static final String KEY_DISTRICT = "district";
    private static final String KEY_SUBCOUNTY = "subcounty";
    private static final String KEY_PARISH = "parish";

    public FarmerDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FARMER_TABLE = "CREATE TABLE " + TABLE_FARMER + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT NOT NULL,"
                + KEY_GENDER + " TEXT NOT NULL," + KEY_CONTACT + " TEXT NOT NULL,"
                + KEY_DISTRICT + " TEXT NOT NULL," + KEY_SUBCOUNTY + " TEXT NOT NULL," + KEY_PARISH + " TEXT NOT NULL" + ")";

        db.execSQL(CREATE_FARMER_TABLE);
    }
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FARMER);

        // Create tables again
        onCreate(db);
    }

    public FarmerDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    void addFarmer(Farmer farmer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, farmer.get_name());
        values.put(KEY_GENDER, farmer.get_gender());
        values.put(KEY_CONTACT, farmer.get_phonenumber());
        values.put(KEY_DISTRICT, farmer.get_district());
        values.put(KEY_SUBCOUNTY, farmer.get_subcounty());
        values.put(KEY_PARISH, farmer.get_parish());
        // Inserting Row
        db.insert(TABLE_FARMER, null, values);
        db.close(); // Closing database connection
    }
    // Getting single post
    Farmer getFarmer(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor;
        cursor = db.query(TABLE_FARMER, new String[]{KEY_ID,
                        KEY_NAME, KEY_GENDER, KEY_CONTACT, KEY_DISTRICT, KEY_SUBCOUNTY, KEY_PARISH}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Farmer farmer = new Farmer(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
        // return contact
        return farmer;
    }
    // Getting All Contacts
    public List<Farmer> getAllFarmer() {
        List<Farmer> farmerList = new ArrayList<Farmer>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FARMER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor;
        cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Farmer farmer = new Farmer();
                farmer.set_id(Integer.parseInt(cursor.getString(0)));
                farmer.set_name(cursor.getString(1));
                farmer.set_gender(cursor.getString(2));
                farmer.set_phonenumber(cursor.getString(3));
                farmer.set_district(cursor.getString(4));
                farmer.set_subcounty(cursor.getString(5));
                farmer.set_parish(cursor.getString(6));

                // Adding contact to list
                farmerList.add(farmer);
            } while (cursor.moveToNext());
        }
        // return contact list
        return farmerList;
    }
    // Updating single contact
    public int updateFarmer(Farmer farmer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, farmer.get_name());
        values.put(KEY_GENDER, farmer.get_gender());
        values.put(KEY_CONTACT, farmer.get_phonenumber());
        values.put(KEY_DISTRICT, farmer.get_district());
        values.put(KEY_SUBCOUNTY, farmer.get_subcounty());
        values.put(KEY_PARISH, farmer.get_parish());

        // updating row
        return db.update(TABLE_FARMER, values, KEY_ID + " = ?",
                new String[]{String.valueOf(farmer.get_id())});
    }
    // Deleting single post
    public void deleteFarmer(Farmer farmer) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FARMER, KEY_ID + " = ?",
                new String[]{String.valueOf(farmer.get_id())});
        db.close();
    }
    // Getting post Count
    public int getFarmerCount() {
        String countQuery = "SELECT  * FROM " + TABLE_FARMER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}