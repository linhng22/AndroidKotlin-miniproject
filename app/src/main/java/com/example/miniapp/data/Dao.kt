package com.example.miniapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user:LocalUser)

    @Query("SELECT * FROM miniapp_users WHERE userName = :userName")
    fun findUser(userName:String) : LocalUser?

}