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
        letScope(dog)
        runScope(person, dog)
        alsoScope(person, dog)
        applyScope(dog)
    }

    private fun applyScope(dog: Dog) {
        Person("Anton", 22).adoptDog(dog)
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
        person.batheDog(dog)
        person.feedDog(dog)
        dog.poop().also { person.cleanDogPoop(it) }
    }

    private fun runScope(
        person: Person,
        dog: Dog
    ) {
        val poop = person.run {
            adoptDog(dog)
            feedDog(dog)
            batheDog(dog)
            dog.poop()
        }
        person.cleanDogPoop(poop)
    }

    private fun letScope(dog: Dog) {
        dog.owner?.let {
            it.feedDog(dog)
            it.batheDog(dog)
            it.cleanDogPoop(dog.poop())
        }
    }

    private fun noScope(
        person: Person,
        dog: Dog
    ) {
        //NO SCOPES
        person.adoptDog(dog)
        person.feedDog(dog)
        person.batheDog(dog)

        val poop = dog.poop()
        person.cleanDogPoop(poop)
    }
}