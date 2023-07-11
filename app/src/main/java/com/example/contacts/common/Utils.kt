package com.example.contacts.common

object Utils {
    fun provideInitials(name: String) =
        name.split(' ')
            .map { it.first().toString() }
            .reduce { acc, c -> acc + c }
            .take(2)
            .uppercase()
}