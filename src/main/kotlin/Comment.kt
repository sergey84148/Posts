package ru.netology

data class Comment(
    val id: Int,
    val postId: Int,
    val fromId: Int,
    val text: String,
    val date: Int
)