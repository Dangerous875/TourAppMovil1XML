package com.example.tourapp.data

data class Purchase(
    val id: Long,
    val userId: Long,
    val packageId: Long,
    val amount: Double,
    val createdDate: String,


)

