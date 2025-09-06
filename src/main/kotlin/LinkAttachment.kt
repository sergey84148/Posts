package ru.netology

data class Link(
    val url: String,
    val title: String,
    val description: String,
    val imageSrc: String
)

data class LinkAttachment(val link: Link) : Attachment("link")