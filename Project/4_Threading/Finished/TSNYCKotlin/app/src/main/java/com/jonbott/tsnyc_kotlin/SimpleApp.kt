package com.jonbott.datalayerexample

import android.app.Application
import android.arch.persistence.room.Room
import com.jonbott.tsnyc_kotlin.iii_DataLayer.DataLayer.DatabaseLayer.RoomExample.LocalDatabase

class SimpleApp: Application() {
    companion object {
        lateinit var database: LocalDatabase
    }

    override fun onCreate() {
        super.onCreate()

        println("🦄 Simple App being used.")
        SimpleApp.database = Room.databaseBuilder(this, LocalDatabase::class.java, "SimpleAppLocalDatabase").build()
    }
}