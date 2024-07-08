package com.example.tourapp.repositories

import com.example.tourapp.data.Purchase
import com.example.tourapp.data.User

object PurchaseRepository {

    private val purchases = mutableListOf<Purchase>()

    init {
        purchases.add(Purchase(1L, 1504L, 1L, 350.50, "2023/01/01"))
        purchases.add(Purchase(2L, 1504L, 4L, 100.75, "2023/01/01"))
        purchases.add(Purchase(3L, 1504L, 7L, 250.50, "2023/01/01"))
        purchases.add(Purchase(4L, 1504L, 10L, 50.00, "2023/01/01"))
        purchases.add(Purchase(5L, 1504L, 3L, 1350.15, "2023/01/01"))
        purchases.add(Purchase(6L, 2802L, 2L, 20.30, "2023/01/01"))
        purchases.add(Purchase(7L, 2802L, 9L, 450.75, "2023/01/01"))
        purchases.add(Purchase(8L, 2802L, 2L, 500.00, "2023/01/01"))
        purchases.add(Purchase(9L, 1510L, 6L, 350.50, "2023/01/01"))
        purchases.add(Purchase(10L, 1510L, 5L, 150.00, "2023/01/01"))
    }

    fun addNewPurchase(purchase: Purchase) {
        purchases.add(purchase)

    }

    fun getPurchasesHistoryCurrenUser(currentUser: User) : List<Purchase> {
        return purchases.filter { it: Purchase -> it.userId == currentUser.id}
    }

    fun getPurchaseslist() : List<Purchase> {
        return purchases
    }
}