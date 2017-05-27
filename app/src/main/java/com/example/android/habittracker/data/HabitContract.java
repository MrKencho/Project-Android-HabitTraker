package com.example.android.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by BaBa_RanChO on 27-05-2017.
 */

public final class HabitContract {
    private HabitContract(){}

public static final class HabitEntry implements BaseColumns{
    public static final String TABLE_NAME = "Habits";

    public static final String _ID = BaseColumns._ID;
    public static final String COLUMN_HABIT_NAME = "HabitName";
    public static final String COLUMN_AGE = "Age";
}


}
