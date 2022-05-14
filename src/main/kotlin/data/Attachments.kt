package data

interface Attachments {
    val type: String
}

data class AttachmentPhoto(
    override val type: String,
    val photo: Photo
) : Attachments

data class AttachmentDoc(
    override val type: String,
    val doc: Doc
) : Attachments

data class AttachmentVideo(
    override val type: String,
    val video: Video
) : Attachments

data class AttachmentAudio(
    override val type: String,
    val audio: Audio
) : Attachments

data class AttachmentNote(
    override val type: String,
    val note: Note
) : Attachments

data class Photo(
    val id: Int,
    val owner_id: Int,
    val date: Int,
    val album_id: Int,
    val user_id: Int,
    val text: String,
    val width: Int,
    val height: Int
)

data class Doc(
    val id: Int,
    val owner_id: Int,
    val date: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val type: Int
)

data class Video(
    val id: Int,
    val owner_id: Int,
    val date: Int,
    val title: String,
    val description: String,
    val duration: Int,
    val width: Int,
    val height: Int
)

data class Audio(
    val id: Int,
    val owner_id: Int,
    val date: Int,
    val artist: String,
    val duration: Int,
    val album_id: Int
)
{
    override fun toString(): String {
        return "Исполнитель: $artist, Длительность: ${duration/60} мин."
    }
}

data class Note(
    val id: Int,
    val owner_id: Int,
    val date: Int,
    val title: String,
    val text: String,
    val comments: Int
) {
    override fun toString(): String {
        return "Заголовок: $title, Текст: $text"
    }
}


