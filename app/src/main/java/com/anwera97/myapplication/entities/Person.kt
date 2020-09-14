package com.anwera97.myapplication.entities

data class Person(val name: String, var age: Int) {

    var dog: Dog? = null

    fun adoptDog(dog: Dog) {
        dog.owner = this
        this.dog = dog
    }

    fun feedDog() {
        dog?.feed()
    }

    fun cleanDogPoop(poop: Poop) {
        poop.clean()
    }

    fun batheDog() {
        dog?.bathe()
    }
}