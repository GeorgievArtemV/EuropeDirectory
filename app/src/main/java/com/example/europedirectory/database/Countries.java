package com.example.europedirectory.database;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Countries {
    @PrimaryKey(autoGenerate = true)
    private long id;

    public Countries(String name, String desc, String url) {
        this.name = name;
        this.desc = desc;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String name;
    private String desc;
    private String url;
}
