package ru.netology

class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var nextCommentId = 1

    fun add(post: Post) {
        posts += post.copy(id = nextPostId++)
    }

    fun update(post: Post): Boolean {
        val index = posts.indexOfFirst { it.id == post.id }
        if (index == -1) return false
        posts[index] = post
        return true
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        val post = posts.find { it.id == postId }
        if (post == null) {
            throw PostNotFoundException("Post with id $postId not found")
        }
        val newComment = comment.copy(id = nextCommentId++)
        comments += newComment
        return newComment
    }

    private var nextPostId = 1
}