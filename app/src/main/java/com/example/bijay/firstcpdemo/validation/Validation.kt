package com.example.bijay.firstcpdemo.validation

object Validation {
    fun isValid(value: String): Boolean {

        if (value.isEmpty()) {
            return false
        }

        return true
    }

    fun isValid(name: String, age: String): Boolean {

        if (name.isEmpty() || age.isEmpty()) {
            return false
        }

        return true
    }
}