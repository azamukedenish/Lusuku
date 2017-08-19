package com.example.bifam.lusuku;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class CommentDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "commentManager.db";
    // Contacts table name
    private static final String TABLE_COMMENT = "comment";
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_CONTACT = "phonenumber";
    private static final String KEY_SUBJECT = "subject";
    private static final String KEY_COMMENT = "comment";

    public CommentDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_COMMENT_TABLE = "CREATE TABLE " + TABLE_COMMENT + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_CONTACT + " TEXT NOT NULL,"
                + KEY_SUBJECT + " TEXT NOT NULL," + KEY_COMMENT + " TEXT NOT NULL" + ")";

        db.execSQL(CREATE_COMMENT_TABLE);
    }
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENT);

        // Create tables again
        onCreate(db);
    }

    public CommentDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    void addComment(Comment comment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CONTACT, comment.get_phonenumber());
        values.put(KEY_SUBJECT, comment.get_subject());
        values.put(KEY_COMMENT, comment.get_comment());
             // Inserting Row
        db.insert(TABLE_COMMENT, null, values);
        db.close(); // Closing database connection
    }
    // Getting single post
    Comment getComment(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor;
        cursor = db.query(TABLE_COMMENT, new String[]{KEY_ID,
                        KEY_CONTACT, KEY_SUBJECT, KEY_COMMENT}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Comment comment = new Comment(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));

        return comment;
    }
    // Getting All Contacts
    public List<Comment> getAllComment() {
        List<Comment> commentList = new ArrayList<Comment>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_COMMENT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor;
        cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Comment comment = new Comment();
                comment.set_id(Integer.parseInt(cursor.getString(0)));
                comment.set_phonenumber(cursor.getString(1));
                comment.set_subject(cursor.getString(2));
                comment.set_comment(cursor.getString(3));

                // Adding contact to list
                commentList.add(comment);
            } while (cursor.moveToNext());
        }
        // return contact list
        return commentList;
    }
    // Updating single contact
    public int updateComment(Comment comment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CONTACT, comment.get_phonenumber());
        values.put(KEY_SUBJECT, comment.get_subject());
        values.put(KEY_CONTACT, comment.get_comment());
        // updating row
        return db.update(TABLE_COMMENT, values, KEY_ID + " = ?",
                new String[]{String.valueOf(comment.get_id())});
    }
    // Deleting single post
    public void deleteComment(Comment comment) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_COMMENT, KEY_ID + " = ?",
                new String[]{String.valueOf(comment.get_id())});
        db.close();
    }
    // Getting post Count
    public int getCommentCount() {
        String countQuery = "SELECT  * FROM " + TABLE_COMMENT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        // return count
        return cursor.getCount();
    }
}
