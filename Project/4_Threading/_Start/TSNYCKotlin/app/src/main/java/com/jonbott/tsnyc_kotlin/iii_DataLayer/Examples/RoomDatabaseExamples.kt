package com.jonbott.tsnyc_kotlin.iii_DataLayer.Examples

import com.jonbott.tsnyc_kotlin.iii_DataLayer.DataLayer.DatabaseLayer.RoomExample.Person
import com.jonbott.datalayerexample.SimpleApp
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

typealias PeopleLambda = (List<Person>)->Unit

object RoomDatabaseExamples {
    fun run() {
        getAllPeople { listOfPeople ->
            println("listOfPeople:")
            println(listOfPeople)
        }

        addPerson("Naruto", "Uzumaki")
        addPerson("Hinata", "Uzumaki")
    }

    private fun getAllPeople(finished: PeopleLambda) {
        launch {
            val people = SimpleApp.database.personDao()
                    .getAllPeople()
            launch(UI) {
                finished(people)
            }
        }
    }

    private fun getAllPeople2(finished: PeopleLambda) {
        SimpleApp.database.personDao()
                .getAllPeople2()
                .subscribeOn( Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { list -> finished(list) }
    }

    private fun addPerson(firstName: String, lastName: String) {
        val person = Person(0, firstName, lastName)

        Single.fromCallable {
            SimpleApp.database.personDao().insert(person)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

}