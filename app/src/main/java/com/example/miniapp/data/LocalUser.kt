package com.example.miniapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "miniapp_users")
data class LocalUser (
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    @ColumnInfo(name = "firstName") val name: String?,
    @ColumnInfo(name = "email") val email:String?,
    @ColumnInfo(name = "password") val password:String?,
    @ColumnInfo(name = "favouriteAnimeIDs") val favouriteAnimeIDs:String?
)