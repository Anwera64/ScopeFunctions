package com.anwera97.myapplication.entities

data class Poop(var kg: Double) {

    fun clean() {
        kg = 0.0
    }
}