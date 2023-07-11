package com.example.contacts.presentation.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun ProfileScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val contactStateFlow = viewModel.contactStateFlow.collectAsState()
    val postStateFlow = viewModel.postStateFlow.collectAsState()
}