package com.jonbott.tsnyc_kotlin.iii_DataLayer.DataLayer.DatabaseLayer.RoomExample

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.jonbott.tsnyc_kotlin.iii_DataLayer.DataLayer.DatabaseLayer.RoomExample.Person
import io.reactivex.Flowable

@Dao
interface PersonDao {
    @Query("SELECT * FROM people")
    fun getAllPeople(): List<Person>

    @Query("SELECT * FROM people")
    fun getAllPeople2(): Flowable<List<Person>>


    @Insert
    fun insert(person: Person)
}