package service

import com.sun.org.apache.xpath.internal.operations.Bool
import data.*

object WallService {

    private var postsArr = emptyArray<Post>()

    fun add(post: Post): Post {
        postsArr += post.copy(id = getLastPostId() + 1)
        println("Post added: ${postsArr.last()}")
        print("Attachments: ")
        if (post.attachments != null) {
            println()
            for (attachment in post.attachments) {
                when (attachment) {
                    is AttachmentPhoto -> {
                        println("✎ Фото | ${attachment.photo}")
                    }
                    is AttachmentDoc -> {
                        println("✎ Документ | ${attachment.doc}")
                    }
                    is AttachmentVideo -> {
                        println("✎ Видео | ${attachment.video}")
                    }
                    is AttachmentAudio -> {
                        println("♫ Аудио | ${attachment.audio}")
                    }
                    is AttachmentNote -> {
                        println("✎ Заметка | ${attachment.note}")
                    }
                }
            }

        } else println("<Вложений нет>")
        return postsArr.last()
    }

    fun update(post: Post): Boolean {
        var postUpdating = false
        for ((idx, currentPost) in postsArr.withIndex()) {
            if (post.id == currentPost.id) {
                postsArr[idx] = currentPost.copy(
                    id = post.id,
                    authorName = post.authorName,
                    content = post.content,
                    likes = post.likes
                )
                postUpdating = true
                println("Updating post with id ${post.id}: ${postsArr[idx]}")
            }
        }
        return postUpdating
    }

    fun getLastPostId(): Int {
        return if (postsArr.isEmpty()) 0 else postsArr.last().id
    }

    fun clearWall() {
        postsArr = emptyArray<Post>()
    }
}