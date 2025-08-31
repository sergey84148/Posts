package ru.netology

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.*

class PostsTest {

    @BeforeEach
    fun setUp() {
        WallService.clear()
    }

    @Test
    fun testAddPostWithZeroID() {
        val initialPost = Post(
            id = 0,
            ownerId = 1,
            fromId = 1,
            date = System.currentTimeMillis(),
            text = "Hello World!"
        )
        val addedPost = WallService.add(initialPost)
        assertNotNull(addedPost.id)
        assertEquals(1, addedPost.id)
    }

    @Test
    fun testUpdateExistingPost() {
        val originalPost = Post(
            id = 1,
            ownerId = 1,
            fromId = 1,
            date = System.currentTimeMillis(),
            text = "Original Text"
        )
        WallService.add(originalPost)

        val updatedPost = originalPost.copy(text = "Updated Text")
        val result = WallService.update(updatedPost)
        assertTrue(result)
    }

    @Test
    fun testUpdateNonexistentPost() {
        val nonExistentPost = Post(
            id = 0,
            ownerId = 1,
            fromId = 1,
            date = System.currentTimeMillis(),
            text = "Some Text"
        )
        val result = WallService.update(nonExistentPost)
        assertFalse(result)
    }
}
