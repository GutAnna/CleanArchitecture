package com.gutsenko.cleanarchitecture.data.storage

import com.gutsenko.cleanarchitecture.data.storage.models.User

interface UserStorage {
   fun save(user: User): Boolean

   fun get(): User
}