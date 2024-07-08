package com.example.tourapp.kotlin

import java.time.LocalDateTime

class BUS(pricePackage: Double, currentDateAndTime: LocalDateTime):
    Transport(pricePackage,currentDateAndTime) {
    override fun calculateCommission(): Double {
        return super.commissionNormalBus
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


