package com.example.miniapp.data


class UsersRepository(private val dao: Dao) { //contains business logics
    fun insertEntity(user: LocalUser) {
        dao.insert(user)
    }

    fun getAll():List<LocalUser> {
        return dao.getAll()
    }

    fun deleteEntity(user:LocalUser) {
        dao.delete(user)
    }

    fun findUser(userName : String) : LocalUser? {
        return dao.findUser(userName)
    }
}