package com.example.tourapp.kotlin

import java.time.LocalDateTime

abstract class Transport (val pricePackage : Double, val currentDateAndTime:LocalDateTime){
    protected val commissionNormalTrain: Double = 0.75
    protected val commissionNormalFerry: Double = 0.0
    protected val commissionNormalBus: Double = 2.0
    protected val commissionNormalAirplane: Double = 1.0
    protected val commissionExtraAirplane: Double = 3.0
    protected val commissionExtraTrain: Double = 3.0

    abstract fun calculateCommission():Double

    abstract fun calculateAmountToPay():Double

    abstract fun getCommission():Double
}