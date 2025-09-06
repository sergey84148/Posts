package ru.netology

data class Post(
    val id: Int = 1,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int? = null, // теперь nullable
    val date: Int = 1633072800,
    val text: String,
    val replyOwnerId: Int? = null,
    val replyPostId: Int? = null,
    val friendsOnly: Boolean = false,
    val copyright: String? = null, // теперь nullable
    val postType: String = "post",
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val signerId: Int? = null,
    val postponedId: Int? = null,
    val comments: Comments? = null, // добавляем nullable комментарий
    val likes: Likes? = null,       // добавляем nullable лайки
    val reposts: Reposts? = null,   // добавляем nullable репосты
    val views: Views? = null,        // добавляем nullable просмотры
    val attachments: List<Attachment>? = null // добавляем список вложений
)

// остальные классы остаются неизменёнными
data class Comments(
    val count: Int,
    val canPost: Boolean = false,
    val groupsCanPost: Boolean = false,
    val canClose: Boolean = false,
    val canOpen: Boolean = false
)

data class Likes(
    val count: Int,
    val userLikes: Boolean = false,
    val canLike: Boolean = false,
    val canPublish: Boolean = false
)

data class Reposts(
    val count: Int,
    val userReposted: Boolean = false
)

data class Views(val count: Int)