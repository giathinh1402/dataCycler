package com.example.dataview;

import androidx.room.Entity;
import androidx.room.PrimaryKey;



@Entity
public class user{
    @PrimaryKey(autoGenerate = true)
    public int userId;
    String name;
    user(String name){
        this.name = name;
    }
}

