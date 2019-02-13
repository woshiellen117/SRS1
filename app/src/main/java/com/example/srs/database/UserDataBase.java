package com.example.srs.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.srs.dao.UserDao;
import com.example.srs.entity.UserEntity;

@Database(entities = {UserEntity.class}, version = 1,exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
