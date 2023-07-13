package com.example.contacts.presentation.profile.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.contacts.model.Post

@Composable
fun PostsList(postsList: List<Post>) {

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(postsList) { post ->

            val titleText = if (post.title.length <= 30) post.title
            else post.title.take(27) + "..."

            val bodyText = if (post.body.length <= 75) post.body
            else post.body.take(72) + "..."

            PostItem(
                titleText = titleText,
                bodyText = bodyText
            )
        }
    }
}