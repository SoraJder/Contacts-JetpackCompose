package com.example.contacts.presentation.profile

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.contacts.common.Resource
import com.example.contacts.common.composables.LoadingIndicator
import com.example.contacts.common.composables.ScreenFailure

@Composable
fun ProfileScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val postStateFlow = viewModel.postStateFlow.collectAsState()

    postStateFlow.value.let { resource ->
        when (resource) {
            is Resource.Failure -> {
                ScreenFailure(errorMessage = resource.message)
            }

            Resource.Loading -> {
                LoadingIndicator()
            }

            is Resource.Success -> {
                Log.d("TEST", resource.data.toString())
            }
        }
    }
}