package com.example.miniapp.data

import com.example.miniapp.data.LocalUser
import com.example.miniapp.data.UserDao


class UsersRepository(private val userDao: UserDao) { //contains business logics
    fun insertEntity(user: LocalUser) {
        userDao.insert(user)
    }

    fun getAll():List<LocalUser> {
        return userDao.getAll()
    }

    fun deleteEntity(user:LocalUser) {
        userDao.delete(user)
    }
}