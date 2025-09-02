package ru.netology

// Класс для хранения списка записей и операций над ними
object WallService {
    private var posts = mutableListOf<Post>()
    private var nextId = 1

    // Метод для добавления новой записи
    fun add(post: Post): Post {
        if (post.id != 0) {
            throw IllegalArgumentException("Нельзя добавить пост с уже установленным идентификатором.")
        }

        val uniqueId = generateUniqueId()
        val newPost = post.copy(id = uniqueId)
        posts.add(newPost)
        return newPost
    }

    // Метод для обновления существующей записи
    fun update(post: Post): Boolean {
        val index = posts.indexOfFirst { it.id == post.id }
        if (index >= 0) {
            posts[index] = post
            return true
        }
        return false
    }

    // Генерация уникального идентификатора
    private fun generateUniqueId(): Int {
        return nextId++
    }

    // Метод для очистки записей (для тестов)
    fun clear() {
        posts.clear()
        nextId = 1
    }
}