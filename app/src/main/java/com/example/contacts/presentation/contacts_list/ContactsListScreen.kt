package com.example.contacts.presentation.contacts_list

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.contacts.common.Resource

@Composable
fun ContactsListScreen(
    navController: NavController,
    viewModel: ContactsListViewModel = hiltViewModel()
) {
    val stateFlow = viewModel.stateFlow.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        stateFlow.value.let { resource ->
            when (resource) {
                is Resource.Failure -> {
                    Text(
                        text = resource.e.message.toString(),
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.Center)
                    )
                }

                Resource.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                
                is Resource.Success -> {
                    LazyColumn(modifier = Modifier.fillMaxSize()){
                        items(resource.data.size){contact ->
                            Log.d("TEST", resource.data[contact].toString())
                            Text(
                                text = resource.data[contact].name,
                                style = MaterialTheme.typography.bodyMedium,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
    }
}