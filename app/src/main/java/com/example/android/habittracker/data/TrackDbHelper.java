package com.example.android.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.android.habittracker.data.HabitContract.HabitEntry.COLUMN_AGE;
import static com.example.android.habittracker.data.HabitContract.HabitEntry.COLUMN_HABIT_NAME;
import static com.example.android.habittracker.data.HabitContract.HabitEntry.TABLE_NAME;
import static com.example.android.habittracker.data.HabitContract.HabitEntry._ID;

/**
 * Created by BaBa_RanChO on 27-05-2017.
 */

public class TrackDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "habits.db";
    public static final int DATABASE_VERSION = 1;

    public TrackDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_HABITS_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + COLUMN_AGE + " INTEGER NOT NULL);";
        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = "DROP TABLE " + TABLE_NAME + ";";
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }
}
