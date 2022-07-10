package com.cary.tempproject

class ViewModel {
    lateinit var userList: List<User>

    init {
        userList = listOf(
            User("홍킬동", 20),
            User("송지효", 21),
            User("이용진", 22),
            User("이진호", 23),
        )
    }
}