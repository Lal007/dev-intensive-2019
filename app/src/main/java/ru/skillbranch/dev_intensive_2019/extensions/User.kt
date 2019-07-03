package ru.skillbranch.dev_intensive_2019.extensions

import ru.skillbranch.dev_intensive_2019.models.User
import ru.skillbranch.dev_intensive_2019.models.UserView
import ru.skillbranch.dev_intensive_2019.utils.Utils

fun User.toUserView() : UserView {

    val nickname = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if (lastVisit == null) " Еще ни разу не был" else if (isOnline) "online" else "Последний раз был ${lastVisit.humanizeDiff()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickName = nickname,
        initials = initials,
        status = status)
}


