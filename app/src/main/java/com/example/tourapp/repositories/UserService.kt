package com.example.tourapp.repositories

import com.example.tourapp.data.TourPackage
import com.example.tourapp.data.TransportType
import com.example.tourapp.data.User
import com.example.tourapp.kotlin.AIRPLANE
import com.example.tourapp.kotlin.BUS
import com.example.tourapp.kotlin.FERRY
import com.example.tourapp.kotlin.TRAIN
import java.time.LocalDateTime

object UserService {
    private var currentUser : User? = null
    private var currentPackage : TourPackage? = null
    private var currentPackageDetail : TourPackage? = null
    private var fullImage : String? = null

    fun getCurrentImage() : String {
        return fullImage!!
    }

    fun setCurrentImage(url : String){
        fullImage = url

    }

    fun getCurrentUser() : User? {
        return  currentUser
    }

    fun setCurrentUser(currentUser: User?){
        UserService.currentUser = currentUser
    }
    fun getCurrentPackage() : TourPackage? {
        return  currentPackage
    }

    fun setCurrentPackage(currentPackage : TourPackage?){
        UserService.currentPackage = currentPackage
    }

    fun getCurrentPackageDetail() : TourPackage? {
        return  currentPackageDetail
    }

    fun setCurrentPackageDetail(currentPackage : TourPackage?){
        currentPackageDetail = currentPackage
    }


    fun calculateAmountToPayForThePackage(currentPackage: TourPackage): Pair<Double, Double>  {
        val transportType : TransportType = currentPackage.transport
        val currentDateAndTime : LocalDateTime = LocalDateTime.now()
        var totalAmountToPay = 0.0
        var commissionTotal = 0.0
        when(transportType){
            TransportType.BUS -> {
                val bus = BUS(currentPackage.price,currentDateAndTime)
                totalAmountToPay = bus.calculateAmountToPay()
                commissionTotal = bus.getCommission()
            }
            TransportType.TRAIN -> {
                val train = TRAIN(currentPackage.price,currentDateAndTime)
                totalAmountToPay = train.calculateAmountToPay()
                commissionTotal = train.getCommission()
            }
            TransportType.AIRPLANE -> {
                val airplane = AIRPLANE(currentPackage.price,currentDateAndTime)
                totalAmountToPay = airplane.calculateAmountToPay()
                commissionTotal = airplane.getCommission()
            }
            TransportType.FERRY -> {
                val ferry = FERRY(currentPackage.price,currentDateAndTime)
                totalAmountToPay = ferry.calculateAmountToPay()
                commissionTotal = ferry.getCommission()
            }
        }
        return Pair(totalAmountToPay , commissionTotal)
    }


}