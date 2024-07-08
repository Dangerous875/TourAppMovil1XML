package com.example.tourapp.data

data class TourPackage(
    val id: Long,
    val name: String,
    val transport: TransportType,
    val duration: Int,
    val stars: Double,
    val price: Double,
    val logo: String,
    val destination: Destination
)
