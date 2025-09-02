package ru.netology

// Класс для хранения информации о посте
data class Post(
    val id: Int = 1,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int? = null,
    val date: Long = System.currentTimeMillis(),
    val text: String,
    val replyOwnerId: Int? = null,
    val replyPostId: Int? = null,
    val friendsOnly: Boolean = false,
    val copyright: String? = null,
    val postType: String = "post",
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val signerId: Int? = null,
    val postponedId: Int? = null
)

// Вспомогательные классы для комментариев, лайков и репостов
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

// Основная точка входа в программу
fun main() {
    println("Привет, это программа для работы с записями.")

    // Демонстрационная логика
    val service = WallService
    val newPost = Post(id = 0, text = "Первая запись", date = System.currentTimeMillis())
    val addedPost = service.add(newPost)
    println("Добавлена новая запись с идентификатором ${addedPost.id}")

    // Обновим запись
    val updatedPost = addedPost.copy(text = "Обновлённая запись")
    val success = service.update(updatedPost)
    println(if (success) "Запись успешно обновлена" else "Запись не найдена")
}