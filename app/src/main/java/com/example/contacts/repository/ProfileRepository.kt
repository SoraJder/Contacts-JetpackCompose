package com.example.contacts.repository

import com.example.contacts.api.ContactsApi
import com.example.contacts.common.Resource
import com.example.contacts.model.Contact
import com.example.contacts.model.Post
import com.example.contacts.model.dto.toContact
import com.example.contacts.model.dto.toPost
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val api: ContactsApi
) {
    suspend fun getContactPosts(contactId: String): Resource<List<Post>> =
        try {
            val result = api
                .getPosts(contactId = contactId)
                .map { postDto ->
                    postDto.toPost()
                }
            Resource.Success(result)
        } catch (e: java.io.IOException) {
            e.printStackTrace()
            Resource.Failure(message = "Couldn't load posts")
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Failure("Couldn't load posts")
        }
}