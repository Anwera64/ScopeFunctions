package com.anwera97.myapplication.entities

data class Person(val name: String, var age: Int) {

    fun adoptDog(dog: Dog) {
        dog.owner = this
    }

    fun feedDog(dog: Dog) {
        dog.feed()
    }

    fun cleanDogPoop(poop: Poop) {
        poop.clean()
    }

    fun batheDog(dog: Dog) {
        dog.bathe()
    }
}