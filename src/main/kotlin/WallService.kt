package ru.netology

object WallService {
    private var nextId = 1L
    private val posts = mutableListOf<Post>()

    fun add(post: Post): Post {
        if (post.id == 0) {
            val newPost = post.copy(id = nextId++.toInt())
            posts.add(newPost)
            return newPost
        } else {
            throw IllegalArgumentException("Пост уже имеет ID")
        }
    }

    fun update(updatedPost: Post): Boolean {
        for ((index, existingPost) in posts.withIndex()) {
            if (existingPost.id == updatedPost.id) {
                posts[index] = updatedPost
                return true
            }
        }
        return false
    }

    fun clear() {
        posts.clear()
        nextId = 1L
    }
}