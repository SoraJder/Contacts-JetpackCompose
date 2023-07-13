package com.example.contacts.model.dto

import com.example.contacts.model.Contact

data class ContactDto(
    val email: String,
    val gender: String,
    val id: Int,
    val name: String,
    val status: String
)

fun ContactDto.toContact() = Contact(
    email = email,
    id = id,
    name = name,
)