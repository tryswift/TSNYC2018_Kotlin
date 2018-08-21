package com.jonbott.tsnyc_kotlin.iii_DataLayer.DataLayer.DatabaseLayer.RoomExample

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(Person::class), version = 1)
abstract class LocalDatabase: RoomDatabase() {
    abstract fun personDao(): PersonDao
}