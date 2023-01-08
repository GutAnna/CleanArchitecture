package com.gutsenko.cleanarchitecture.data.storage

interface UserStorage {
   fun save(user: User): Boolean

   fun get(): User
}