package com.example.mad_ex5;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "PersonalInfoDB";
    private static final int DB_VERSION = 1;
    private static final String ID_COL = "id";
    private static final String TABLE_NAME = "PerosnalInfo";
    private static final String NAME_COL = "name";
    private static final String ADDR_COL = "address";
    private static final String PHONE_COL = "phone";
    private static final String EMAIL_COL = "email";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + ADDR_COL + " TEXT,"
                + PHONE_COL + " TEXT,"
                + EMAIL_COL + " TEXT UNIQUE)";

        db.execSQL(query);
    }

    public void addNewEntry(String name, String addr, String phone, String email) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME_COL, name);
        values.put(ADDR_COL, addr);
        values.put(PHONE_COL, phone);
        values.put(EMAIL_COL, email);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public ArrayList<PersonalInfoModal> getInfo() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor PersonalInfoCursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<PersonalInfoModal> PersonalInfoList = new ArrayList<>();

        if (PersonalInfoCursor.moveToFirst()) {
            do {
                PersonalInfoList.add(new PersonalInfoModal(PersonalInfoCursor.getInt(0),PersonalInfoCursor.getString(1),
                        PersonalInfoCursor.getString(2),
                        PersonalInfoCursor.getString(3),
                        PersonalInfoCursor.getString(4)));
            } while (PersonalInfoCursor.moveToNext());
        }
        PersonalInfoCursor.close();
        return PersonalInfoList;
    }

    public PersonalInfoModal getIndividualInfo(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor PersonalInfoCursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " where "+ NAME_COL + "=?", new String[]{name});

        if (PersonalInfoCursor.moveToFirst()) {
            return new PersonalInfoModal(PersonalInfoCursor.getInt(0),PersonalInfoCursor.getString(1),
                        PersonalInfoCursor.getString(2),
                        PersonalInfoCursor.getString(3),
                        PersonalInfoCursor.getString(4));

        }
        PersonalInfoCursor.close();
        return null;
    }

    public void updateInfo(String name, String addr, String phone,
                             String email) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ADDR_COL, addr);
        values.put(PHONE_COL, phone);
        values.put(EMAIL_COL, email);

        db.update(TABLE_NAME, values, "name=?", new String[]{name});
        db.close();
    }

    public void deleteEntry(String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, "name=?", new String[]{name});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}