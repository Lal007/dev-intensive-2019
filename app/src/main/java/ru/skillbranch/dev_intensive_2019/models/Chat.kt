package ru.skillbranch.dev_intensive_2019.models


class Chat(
    val id:String,
    val members: MutableList<User> = mutableListOf(),
    val message: MutableList<BaseMessage> = mutableListOf()
) {
}