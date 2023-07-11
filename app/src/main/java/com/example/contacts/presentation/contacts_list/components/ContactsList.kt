package com.example.contacts.presentation.contacts_list.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.contacts.model.Contact
import com.example.contacts.ui.theme.BackgroundListColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContactsList(
    contactsList: List<Contact>
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Contacte",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .background(BackgroundListColor)
        ) {
            stickyHeader {
                Text(
                    text = "CONTACTELE MELE",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color(0xFF9DAAC2),
                    modifier = Modifier.padding(16.dp),
                )
            }
            items(contactsList) { contact ->
                ContactListItem(contact = contact)
                Divider(thickness = 1.dp, color = Color(243, 246, 249))
            }
        }
    }
}