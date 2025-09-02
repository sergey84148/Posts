package ru.netology

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WallServiceTest {

    @BeforeEach
    fun setup() {
        WallService.clear()
    }

    @Test
    fun testAddPost() {
        // Создаем новый пост с id = 0
        val initialPost = Post(id = 0, text = "Новая запись")
        val addedPost = WallService.add(initialPost)

        // Проверяем, что идентификатор поста изменился и стал положительным
        assertNotEquals(0, addedPost.id)
    }

    @Test
    fun testUpdateExistingPost() {
        // Создаем первоначальный пост с id = 0
        val initialPost = Post(id = 0, text = "Первоначальный текст")
        val addedPost = WallService.add(initialPost)

        // Обновляем текст поста
        val updatedPost = addedPost.copy(text = "Обновлённый текст")

        // Обновляем пост
        val result = WallService.update(updatedPost)

        // Проверяем, что обновление прошло успешно
        assertTrue(result)
    }

    @Test
    fun testUpdateNonexistentPost() {
<<<<<<< HEAD
        // Пробуем обновить несуществующий пост
        val fakePost = Post(id = 100, text = "Несуществующий текст")
        val result = WallService.update(fakePost)

        // Должно вернуться false
=======
        val nonExistentPost = Post(
            id = 100,
            ownerId = 1,
            fromId = 1,
            date = System.currentTimeMillis(),
            text = "Some Text"
        )
        val result = WallService.update(nonExistentPost)
>>>>>>> f2922514832b1f39936034c70999fefb697ab8e3
        assertFalse(result)
    }
}