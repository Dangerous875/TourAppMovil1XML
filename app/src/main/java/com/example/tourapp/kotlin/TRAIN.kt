package com.example.tourapp.kotlin

import java.time.DayOfWeek
import java.time.LocalDateTime

class TRAIN (pricePackage: Double, currentDateAndTime: LocalDateTime):
    Transport(pricePackage,currentDateAndTime) {
    override fun calculateCommission(): Double {
        if (currentDateAndTime.dayOfWeek.name == DayOfWeek.SATURDAY.name || currentDateAndTime.dayOfWeek.name == DayOfWeek.SUNDAY.name){
            return super.commissionExtraTrain
        }
        return  super.commissionNormalTrain
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