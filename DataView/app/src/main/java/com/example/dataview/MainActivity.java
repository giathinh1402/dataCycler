package com.example.dataview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    userDatabase db;
    userAdapter userAdapter;
    RecyclerView rv;


    private static List<user> Users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(),
                userDatabase.class, "database-name").build();
        rv = findViewById(R.id.rvDebtor);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onResume(){
        super.onResume();
        getData();
    }

    private void getData(){
        new AsyncTask<Void, Void, List<user>>() {
            @Override
            protected List<user> doInBackground(Void... voids) {
                Users = db.userDao().getAll();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        userAdapter = new userAdapter(this, Users);
                        //  userAdapter.setOnClick(MainActivity.this);
                        rv.setAdapter(userAdapter);
                    }
                });
                return null;
            }
        }.execute();
    }
}
