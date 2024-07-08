package com.example.tourapp.repositories

import com.example.tourapp.R
import com.example.tourapp.data.User
import java.text.DecimalFormat

object UserRepository {

    private val users = mutableListOf<User>()
    private var userActual: User? = null

    init {
        users.add(User(1504L, "BRIAN_BAYARRI", "abc123", "Brian", "Bayarri", 3500000.50, "2022/12/10"))
        users.add(User(2802L, "AHOZ", "lock_password", "Aylen", "Hoz", 200000.50, "2021/01/11"))
        users.add(User(1510L, "Diegote", "1234", "Diego", "Gonzalez", 120000.0, "2018/04/15"))
        users.add(User(1765L, "Sofi", "0123", "Sofía", "Rodriguez", 520000.5, "2019/06/29"))
        users.add(User(1820L, "Giuli", "4567", "Giuliana", "Menicucci", 435000.5, "2020/03/12"))
        users.add(User(1515L, "Cris", "0000", "Cristian", "Barzabal", 4505000.5, "2019/09/15"))
        users.add(User(1754L, "Gabi", "1111", "Gabriel", "Pezet", 335000.5, "2023/01/20"))
    }
    fun login(nickname: String, password: String) : User? {
        userActual = users.find { it.nickName.equals(nickname, ignoreCase = true) && it.password == password }
        return userActual
    }

    fun modifyMoney(currentUser : User, packageCost : Double){
        val user = users.find { it == currentUser }
        user!!.money -= packageCost
        val formattedMoney: Double = DecimalFormat("#.##").format(user!!.money).toDouble()
        user.money = formattedMoney
    }

    fun addUser(currentUser: User){
        users.add(currentUser)
    }

    fun containUser(nickname: String): Boolean {
        return users.any { it.nickName.equals(nickname, ignoreCase = true) }
    }

    fun getPhotoResource(fullName: String): Int {
        val names = listOf("Diego", "Brian", "Aylen", "Sofía", "Giuliana", "Cristian", "Gabriel")

        return when (names.indexOfFirst { fullName.contains(it, ignoreCase = true) }) {
            0 -> R.drawable.diego
            1 -> R.drawable.brian

            else -> R.drawable.imagen_generica
        }

    }
}