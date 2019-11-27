package com.example.dataview;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface userDao {
    @Query("SELECT * from user")
    List<user> getAll();

    @Insert
    void insert(user user);
}
