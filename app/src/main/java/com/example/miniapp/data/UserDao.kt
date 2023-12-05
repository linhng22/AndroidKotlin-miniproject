package com.example.miniapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM miniapp_users")
    fun getAll():List<LocalUser>

    @Insert()
    fun insert(user:LocalUser)

    @Delete
    fun delete(user:LocalUser)



}