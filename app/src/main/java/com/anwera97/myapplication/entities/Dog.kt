package com.anwera97.myapplication.entities

import kotlin.random.Random

data class Dog(val name: String, var age: Int, val race: String) {
    var owner: Person? = null

    fun ageUp() = age++

    fun feed() {
        //Dog is happy
    }

    fun bathe() {
        //Dog isn't happy
    }

    fun poop(): Poop {
        return Poop(Random.nextDouble(0.1, 0.5))
    }
}