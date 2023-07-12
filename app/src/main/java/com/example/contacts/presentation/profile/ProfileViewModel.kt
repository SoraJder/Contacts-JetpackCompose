package com.example.contacts.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contacts.common.Resource
import com.example.contacts.model.Post
import com.example.contacts.navigation.ContactHolder
import com.example.contacts.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
) : ViewModel() {

    private val _postStateFlow: MutableStateFlow<Resource<List<Post>>> =
        MutableStateFlow(Resource.Loading)
    val postStateFlow: StateFlow<Resource<List<Post>>> = _postStateFlow.asStateFlow()

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            _postStateFlow.value = profileRepository.getContactPosts(ContactHolder.contactId!!)
        }
    }
}