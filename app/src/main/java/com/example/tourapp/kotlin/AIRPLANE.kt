package com.example.tourapp.kotlin
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class AIRPLANE (pricePackage: Double, currentDateAndTime: LocalDateTime):
    Transport(pricePackage,currentDateAndTime) {

    override fun calculateCommission(): Double {

        val startTime = "15:00"; val finalHour = "22:30"
        val initialTimeRange: LocalTime = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"))
        val endTimeRange: LocalTime = LocalTime.parse(finalHour, DateTimeFormatter.ofPattern("HH:mm"))
        if (currentDateAndTime.toLocalTime()>=initialTimeRange && currentDateAndTime.toLocalTime()<= endTimeRange){
            return super.commissionNormalAirplane
        }
        return super.commissionExtraAirplane
    }

    override fun calculateAmountToPay(): Double {
        val finalCommission: Double = calculateCommission()
        return totalToPay(pricePackage, finalCommission)
    }

    override fun getCommission(): Double {
        return calculateCommission()
    }

    private fun totalToPay(pricePackage:Double, finalCommission:Double):Double=pricePackage+((pricePackage*finalCommission)/100)
}