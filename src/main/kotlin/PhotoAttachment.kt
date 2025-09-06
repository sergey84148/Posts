package ru.netology

data class Photo(
    val id: Int,
    val ownerId: Int,
    val photo130: String,
    val photo604: String
)

data class PhotoAttachment(val photo: Photo) : Attachment("photo")