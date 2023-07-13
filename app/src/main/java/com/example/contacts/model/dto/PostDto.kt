package com.example.contacts.model.dto

import com.example.contacts.model.Post

data class PostDto(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)

fun PostDto.toPost() = Post(
    title = title,
    body = body
)