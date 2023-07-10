package com.example.contacts.repository

import com.example.contacts.api.ContactsApi
import com.example.contacts.common.Resource
import com.example.contacts.model.Contact
import com.example.contacts.model.dto.toContact
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class ContactsRepository @Inject constructor(
    private val api: ContactsApi
) {
    suspend fun getContacts(): Resource<List<Contact>> =
        try {
            val contacts = api.getContacts()
                .filter { contactDto ->
                    contactDto.status == "active"
                }
                .map { contactDto ->
                    contactDto.toContact()
                }
            Resource.Success(contacts)
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Failure(e)
        } catch (e: HttpException) {
            Resource.Failure(e)
        }

}