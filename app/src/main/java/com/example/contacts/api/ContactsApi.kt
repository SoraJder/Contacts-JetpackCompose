package com.example.contacts.api

import com.example.contacts.model.dto.ContactDto
import retrofit2.http.GET

interface ContactsApi {

    @GET("/users")
    suspend fun getContacts():List<ContactDto>

}