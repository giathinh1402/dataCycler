package com.example.dataview;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {user.class}, version = 4)
public abstract class userDatabase extends RoomDatabase {

    abstract userDao userDao();

}
