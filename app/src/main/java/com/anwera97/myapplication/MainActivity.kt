package com.anwera97.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anwera97.myapplication.entities.Dog
import com.anwera97.myapplication.entities.Person
import com.anwera97.myapplication.entities.Poop

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val person = Person("Anton", 22)
        val dog = Dog("Bielka", 6, "Chusca")

        noScope(person, dog)

        letScope(person)

        runScope(person, dog)

        alsoScope(person, dog)

        applyScope(dog)
    }

    private fun applyScope(dog: Dog) {
        dog.apply {
            feed()
            bathe()
            owner?.cleanDogPoop(poop())
        }
    }

    private fun alsoScope(
        person: Person,
        dog: Dog
    ) {
        person.batheDog()
        person.feedDog()
        dog.poop().also(person::cleanDogPoop)
    }

    private fun runScope(
        person: Person,
        dog: Dog
    ) {
        person.run {
            adoptDog(dog)
            feedDog()
            batheDog()
            dog.poop()
        }.clean()
    }

    private fun letScope(person: Person) {
        var poop: Poop? = null
        person.dog?.apply {
            feed()
            bathe()
            poop = poop()
        }
        person.cleanDogPoop(poop!!)
    }

    private fun noScope(
        person: Person,
        dog: Dog
    ) {
        //NO SCOPES
        person.adoptDog(dog)
        person.feedDog()
        person.batheDog()

        val poop = dog.poop()
        person.cleanDogPoop(poop)
    }
}