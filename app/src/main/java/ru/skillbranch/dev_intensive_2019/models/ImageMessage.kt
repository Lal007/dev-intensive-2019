package ru.skillbranch.dev_intensive_2019.models

import ru.skillbranch.dev_intensive_2019.extensions.humanizeDiff
import java.util.*

class ImageMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean,
    date: Date = Date(),
    var image:String?
) : BaseMessage(id, from, chat, isIncoming, date) {
    override fun formatMessage(): String {
        return "${from?.firstName} ${if (isIncoming) "получил" else "отправил"} изображение \\\"$image\\\" ${date.humanizeDiff()}"
    }
}