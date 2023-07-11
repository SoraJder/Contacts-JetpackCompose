package com.example.contacts.api

import com.example.contacts.model.dto.ContactDto
import com.example.contacts.model.dto.PostDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ContactsApi {

    @GET("public/v2/users")
    suspend fun getContacts(): List<ContactDto>

    @GET("public/v2/users/{contactId}")
    suspend fun getContact(@Path("contactId") contactId: String): ContactDto

    @GET("public/v2/users/{contactId}/posts")
    suspend fun getPosts(@Path("contactId") contactId: String): List<PostDto>

}