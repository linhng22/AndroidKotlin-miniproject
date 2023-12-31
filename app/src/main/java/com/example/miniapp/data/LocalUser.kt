package com.example.miniapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "miniapp_users")
data class LocalUser (
    @PrimaryKey @ColumnInfo(name="userName") val userName : String,
    @ColumnInfo(name = "password") val password:String?,
    @ColumnInfo(name = "favouriteAnimeIDs") var favouriteAnimeIDs:String
)