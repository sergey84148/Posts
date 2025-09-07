package ru.netology

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WallServiceTest {

    @Test
    fun testCreateCommentSuccess() {
        val wallService = WallService()
        val post = Post(id = 1, ownerId = 1, fromId = 1, text = "Test post")
        wallService.add(post)

        val comment = Comment(id = 0, postId = 1, fromId = 1, text = "Test comment", date = 1633072800)
        val createdComment = wallService.createComment(1, comment)

        assertEquals(1, createdComment.id)
        assertEquals(1, createdComment.postId)
        assertEquals("Test comment", createdComment.text)
    }

    @Test
    fun testCreateCommentPostNotFound() {
        val wallService = WallService()
        val comment = Comment(id = 0, postId = 1, fromId = 1, text = "Test comment", date = 1633072800)

        assertThrows<PostNotFoundException> {
            wallService.createComment(1, comment)
        }
    }
}