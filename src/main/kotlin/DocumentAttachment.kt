package ru.netology

data class Document(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String
)

data class DocumentAttachment(val document: Document) : Attachment("doc")