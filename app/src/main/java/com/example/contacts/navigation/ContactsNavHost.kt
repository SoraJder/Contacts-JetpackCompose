package com.example.contacts.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.contacts.presentation.contacts_list.ContactsListScreen
import com.example.contacts.presentation.profile.ProfileScreen

@Composable
fun ContactsNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.CONTACTS_LIST_SCREEN
    ) {
        composable(
            route = Screens.CONTACTS_LIST_SCREEN
        ) {
            ContactsListScreen(navController = navController)
        }
        composable(
            route = Screens.PROFILE_SCREEN,
        ) {
            ProfileScreen(
                navController = navController,
            )
        }
    }
}