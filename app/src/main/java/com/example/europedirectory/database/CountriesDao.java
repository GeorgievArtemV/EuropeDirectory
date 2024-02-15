package com.example.europedirectory.database;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface CountriesDao {
    @Query("SELECT * FROM Countries")
    List<Countries> getAll();

    @Insert
    void insert (Countries countries);
    @Delete
    void delete (Countries countries);
    @Update
    void update (Countries countries);
    @Query("SELECT * FROM Countries WHERE name = :name")
    Single<Countries> getByName(String name);
}
