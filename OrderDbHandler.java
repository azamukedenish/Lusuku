package com.example.bifam.lusuku;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class OrderDbHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "orderManager.db";
    // Contacts table name
    private static final String TABLE_ORDER = "orders";
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_CONTACT = "phone_number";
    private static final String KEY_PRODUCENAME = "producename";
    private static final String KEY_QUANTITY = "quantity";
    private static final String KEY_NDATE = "ndate";
    private static final String KEY_ODATE = "odate";
    private static final String KEY_UNITPRICE = "unitprice";

    public OrderDbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
          String CREATE_ORDER_TABLE = "CREATE TABLE " + TABLE_ORDER + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_CONTACT + " TEXT NOT NULL,"
                + KEY_PRODUCENAME + " TEXT NOT NULL," + KEY_QUANTITY + " TEXT NOT NULL,"
                + KEY_NDATE + " TEXT NOT NULL," + KEY_ODATE + " TEXT NOT NULL," + KEY_UNITPRICE + " TEXT NOT NULL" + ")";

        db.execSQL(CREATE_ORDER_TABLE);
    }
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDER);

        // Create tables again
        onCreate(db);
    }

    public OrderDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    void addOrder(Order order) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CONTACT, order.get_phonenumber());
        values.put(KEY_PRODUCENAME, order.get_producename());
        values.put(KEY_QUANTITY, order.get_quntity());
        values.put(KEY_NDATE, order.get_ndate());
        values.put(KEY_ODATE, order.get_odate());
        values.put(KEY_UNITPRICE, order.get_unitprice());
        // Inserting Row
        db.insert(TABLE_ORDER, null, values);
        db.close(); // Closing database connection
    }
    // Getting single post
    Order getOrder(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor;
        cursor = db.query(TABLE_ORDER, new String[]{KEY_ID,
                        KEY_CONTACT, KEY_PRODUCENAME, KEY_QUANTITY, KEY_NDATE, KEY_ODATE, KEY_UNITPRICE}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Order order = new Order(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
        // return contact
        return order;
    }
    // Getting All Contacts
    public List<Order> getAllOrders() {
        List<Order> orderList = new ArrayList<Order>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ORDER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor;
        cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Order order = new Order();
                order.set_id(Integer.parseInt(cursor.getString(0)));
                order.set_phonenumber(cursor.getString(1));
                order.set_producename(cursor.getString(2));
                order.set_quntity(cursor.getString(3));
                order.set_ndate(cursor.getString(4));
                order.set_odate(cursor.getString(5));
                order.set_unitprice(cursor.getString(6));

                // Adding contact to list
                orderList.add(order);
            } while (cursor.moveToNext());
        }
        // return contact list
        return orderList;
    }
    // Updating single contact
    public int updateOrder(Order order) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CONTACT, order.get_phonenumber());
        values.put(KEY_PRODUCENAME, order.get_producename());
        values.put(KEY_QUANTITY, order.get_quntity());
        values.put(KEY_NDATE, order.get_ndate());
        values.put(KEY_ODATE, order.get_odate());
        values.put(KEY_UNITPRICE, order.get_unitprice());

        // updating row
        return db.update(TABLE_ORDER, values, KEY_ID + " = ?",
                new String[]{String.valueOf(order.get_id())});
    }
    // Deleting single post
    public void deleteOrder(Order order) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ORDER, KEY_ID + " = ?",
                new String[]{String.valueOf(order.get_id())});
        db.close();
    }
    // Getting post Count
    public int getOrderCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ORDER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}
