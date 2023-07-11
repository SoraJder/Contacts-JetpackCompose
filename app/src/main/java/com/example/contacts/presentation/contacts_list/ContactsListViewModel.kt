package com.example.contacts.presentation.contacts_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contacts.common.Resource
import com.example.contacts.model.Contact
import com.example.contacts.repository.ContactsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactsListViewModel @Inject constructor(
    private val contactsRepository: ContactsRepository
) : ViewModel() {

    private val _stateFlow: MutableStateFlow<Resource<List<Contact>>> =
        MutableStateFlow(Resource.Loading)
    val stateFlow: StateFlow<Resource<List<Contact>>> = _stateFlow.asStateFlow()

    init {
        getContactList()
    }

    private fun getContactList() {
        viewModelScope.launch {
            _stateFlow.value = contactsRepository.getContacts()
        }
    }
}