package com.example.myapplication22;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    static String name = "application22";
    static int version = 1;

    String createTableUser = "CREATE TABLE if not exists \"user\" (\n" +
            "\t\"id\"\tINTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
            "\t\"username\"\tTEXT UNIQUE,\n" +
            "\t\"password\"\tTEXT,\n" +
            "\t\"email\"\tTEXT,\n" +
            "\t\"address\"\tTEXT,\n" +
            "\t\"phone\"\tTEXT,\n" +
            "\t\"gender\"\tTEXT,\n" +
            "\t\"image\"\tBLOB\n" +
            ")";

    public DatabaseHelper(Context context) {
        super(context, name, null, version);
        getWritableDatabase().execSQL(createTableUser);
    }

    public void insertUser(ContentValues contentValues) {
        getWritableDatabase().insert("user", "", contentValues);
    }
    public UserInfo getUserinfo(String id) {
        String sql = "Select * from user where id=" + 1;
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        UserInfo info = new UserInfo();
        while (cursor.moveToNext()) {
            info.id = cursor.getString(cursor.getColumnIndex("id"));
            info.username = cursor.getString(cursor.getColumnIndex("username"));
            info.address = cursor.getString(cursor.getColumnIndex("address"));
            //info.image = cursor.getBlob(cursor.getColumnIndex("image"));

        }
        cursor.close();
        return info;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createTableUser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(createTableUser);

    }
}
