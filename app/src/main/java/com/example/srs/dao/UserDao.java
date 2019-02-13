package com.example.srs.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.srs.entity.UserEntity;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<UserEntity> getAll();

    @Query("SELECT * FROM user WHERE user_id IN (:userIds)")
    List<UserEntity> loadAllByIds(int[] userIds);

//    @Query("SELECT * FROM user WHERE username = userName ")
//    UserEntity findByName(String userName);

    @Insert
    void insertAll(UserEntity... users);

    @Delete
    void delete(UserEntity user);
}
