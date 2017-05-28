package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.android.habittracker.data.TrackDbHelper;

import static com.example.android.habittracker.data.HabitContract.HabitEntry.COLUMN_AGE;
import static com.example.android.habittracker.data.HabitContract.HabitEntry.COLUMN_HABIT_NAME;
import static com.example.android.habittracker.data.HabitContract.HabitEntry.TABLE_NAME;


public class MainActivity extends AppCompatActivity {

    TrackDbHelper mDbHelper = new TrackDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Inserting Habits
    private void insertHabit(){
        //We can get the name of the habit and the age from Edit text too.
        String habitName = "Walk the Dog";
        int age = 100;
        ContentValues habit = new ContentValues();
        habit.put(COLUMN_HABIT_NAME,habitName);
        habit.put(COLUMN_AGE,age);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        long returnID = db.insert(TABLE_NAME,null,habit);
        if(returnID == -1)
            Log.e("MainActivity:","Error while adding habit");
    }

    //Reading habits
    private Cursor readDb(){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                COLUMN_HABIT_NAME, COLUMN_AGE
        };

        return db.query(TABLE_NAME,projection,null,null,null,null,null);
    }

    //Displays data from database
    private void readHabit(){
        TextView displayView = (TextView) findViewById(R.id.habit);
        displayView.setText(R.string.displayHeading);

        Cursor cursor = readDb();

        try {
            int habitNameIndex = cursor.getColumnIndex(COLUMN_HABIT_NAME);
            int ageInex = cursor.getColumnIndex(COLUMN_AGE);


            while (cursor.moveToNext()){
                String currentHabitName = cursor.getString(habitNameIndex);
                int currentAge = cursor.getInt(ageInex);
                String age = Integer.toString(currentAge);

                displayView.append("\n"+currentHabitName+" ---- "+age);
            }
        }
        finally {
            cursor.close();
        }
    }
}
