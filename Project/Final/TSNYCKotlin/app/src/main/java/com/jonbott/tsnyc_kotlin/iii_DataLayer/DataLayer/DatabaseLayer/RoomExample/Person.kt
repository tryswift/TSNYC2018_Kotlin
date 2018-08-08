package com.jonbott.tsnyc_kotlin.iii_DataLayer.DataLayer.DatabaseLayer.RoomExample

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "people")
data class Person(
        @PrimaryKey(autoGenerate = true)
        var uid: Long = 0,
        var firstName: String = "",
        var lastName: String = ""
)