package com.jonbott.androidui.Helpers

import com.jonbott.Utils.random
import com.jonbott.Utils.Spy

object SpyCreator {
    val names = listOf(  "Guadalupe Baker",  "Emmett Riley",  "Gerardo Hoffman",  "Elaine Watkins",  "Travis Santos",  "Dawn Evans",  "Winifred Brock",  "Courtney Erickson",  "Gene Bass",  "Mae Murray",  "Donald Floyd",  "Derek Franklin",  "Duane Benson",  "Ida Austin",  "Jaime Duncan",  "Edward Cross",  "Warren Ward",  "Marlon Lamb",  "Eduardo Carter",  "Eunice Harrison",  "Kyle Lane",  "Andre Cannon",  "Scott Bradley",  "Tammy Reed",  "Arthur Hampton",  "Ollie Moss",  "Margaret Ortega",  "Bethany Ramirez",  "Vanessa Sanders",  "Randolph Perez",  "Silvia Bates",  "Dave Love",  "Casey Warner",  "Raul Stone",  "Julio Warren",  "Tabitha Gill",  "Cory Rowe",  "Pearl Jimenez",  "June Simpson",  "Oliver Jensen",  "Boyd Davidson",  "Pedro Howell",  "Trevor Craig",  "Phillip Andrews",  "Jeanne Wagner",  "Darrell Clarke",  "Carla Blair",  "Bryan Schneider",  "Terrell Pierce",  "Wilbert Alvarado",  "Stacey George",  "Shannon Shaw",  "Mamie Dennis",  "Tyrone Holt",  "Leah Thompson",  "Blake Owen",  "Sheri Patterson",  "Darrin Banks",  "Kayla Watson",  "Juan Russell",  "Leigh Thomas",  "Leslie Alvarez",  "Melba Scott",  "Dominick Stanley",  "Mabel Patton",  "Debbie Fuller",  "Lonnie Potter",  "Kenneth Bowman",  "Minnie Green",  "Amy Page",  "Luke Harvey",  "Nina Hopkins",  "Tina Mendez",  "Joan Lucas",  "Wesley Wheeler",  "Samantha Armstrong",  "Fred Fields",  "Lyle Goodman",  "Kim Harris",  "Jaime Garza",  "Tiffany Powers",  "Omar Mack",  "Willard Keller",  "Sean Gutierrez",  "Rex Cook",  "Ana Logan",  "Katrina Norris",  "Billy Schwartz",  "Danny Huff",  "Emanuel Hines",  "Tommie Ramos",  "Hazel Ray",  "Edgar Cruz",  "Julie Cobb",  "Rudolph Horton",  "Arlene Wolfe",  "Gloria Haynes",  "Patty Nunez",  "Jessie Newton",  "Marcus Gonzalez" )
    val images = listOf( "spyf01",  "spyf02",  "spyf03",  "spyf04",  "spyf05",  "spyf06",  "spym01",  "spym02",  "spym03",  "spym04",  "spym05",  "spym06")

    fun next(): Spy {
        val age       = getRandomAge()
        val name      = getRandomName()
        val imageName = getRandomImage()

        val spy = Spy(name, age, imageName)
        return spy
    }

    private fun getRandomAge(): Int {
        return (0..100).random()
    }

    private fun getRandomName(): String {
        val index = (1..names.count()).random() - 1 //zero based
        return names[index]
    }

    private fun getRandomImage(): String {
        val index = (1..images.count()).random() - 1 //zero based
        return images[index]
    }
}