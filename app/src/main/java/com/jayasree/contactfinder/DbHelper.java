package com.jayasree.contactfinder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "contact";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TALUK= "taluk";
    public static final String COLUMN_VILLAGE= "village";
    public static final String COLUMN_LAND_NO= "land_no";
    public static final String COLUMN_MOBLIE_NO= "moblie_no";



    String createTable() {
       String sql = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TALUK + " TEXT,"
                + COLUMN_VILLAGE + " TEXT,"
                + COLUMN_LAND_NO + " TEXT,"
                + COLUMN_MOBLIE_NO + " TEXT"
                + ")";
       return sql;
    }


    public DbHelper(Context context) {
        super(context, "ContactFinder", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable());
        Log.d("gtec", "onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long insertContact(String taluke,String village,String land_no,String mobile_no) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TALUK, taluke);
        cv.put(COLUMN_VILLAGE, village);
        cv.put(COLUMN_LAND_NO, land_no);
        cv.put(COLUMN_MOBLIE_NO, mobile_no);

        long id = db.insert(TABLE_NAME, null, cv);
        db.close();

        return id;
    }

    public Contact getContact(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null,
                COLUMN_ID + "=?",new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();
        Contact contact = new Contact(
                cursor.getInt(cursor.getColumnIndex(COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(COLUMN_TALUK)),
                cursor.getString(cursor.getColumnIndex(COLUMN_VILLAGE)),
                cursor.getString(cursor.getColumnIndex(COLUMN_LAND_NO)),
                cursor.getString(cursor.getColumnIndex(COLUMN_MOBLIE_NO))
        );
        cursor.close();
        return contact;
    }

    public List<Contact> getAllContact() {
        List<Contact> contacts = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact(
                        cursor.getInt(cursor.getColumnIndex(COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_TALUK)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_VILLAGE)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_LAND_NO)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_MOBLIE_NO))
                );

                contacts.add(contact);
            } while (cursor.moveToNext());
        }
        db.close();
        return contacts;
    }

    public int getCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        int count=cursor.getCount();
        cursor.close();
        return count;
    }

}