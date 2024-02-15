package com.example.europedirectory.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Countries.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract CountriesDao countrysDao();
}
