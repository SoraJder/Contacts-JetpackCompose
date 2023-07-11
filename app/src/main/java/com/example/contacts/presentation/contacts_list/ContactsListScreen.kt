package com.example.contacts.presentation.contacts_list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.contacts.common.Resource
import com.example.contacts.common.composables.LoadingIndicator
import com.example.contacts.common.composables.ScreenFailure
import com.example.contacts.presentation.contacts_list.components.ContactsList

@Composable
fun ContactsListScreen(
    navController: NavController,
    viewModel: ContactsListViewModel = hiltViewModel()
) {
    val stateFlow = viewModel.stateFlow.collectAsState()

    stateFlow.value.let { resource ->
        when (resource) {
            is Resource.Failure -> {
                ScreenFailure(
                    errorMessage = resource.message
                )
            }

            Resource.Loading -> {
                LoadingIndicator()
            }

            is Resource.Success -> {
                ContactsList(
                    contactsList = resource.data,
                   navController= navController
                )
            }
        }
    }
}