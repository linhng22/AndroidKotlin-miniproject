package com.example.miniapp.data


class UsersRepository(private val dao: Dao) {
    fun insertEntity(user: LocalUser) {
        dao.insert(user)
    }

    fun findUser(userName : String) : LocalUser? {
        return dao.findUser(userName)
    }
}