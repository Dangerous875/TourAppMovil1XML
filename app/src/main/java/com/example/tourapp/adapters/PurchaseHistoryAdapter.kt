package com.example.tourapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tourapp.data.Purchase
import com.example.tourapp.data.TourPackage
import com.example.tourapp.databinding.ItemHistoryuserBinding
import com.example.tourapp.repositories.PackageRepository
import com.example.tourapp.repositories.UserService

class PurchaseHistoryAdapter(private val purchaseList : List<Purchase> , val selectPurchase : (Purchase) -> Unit
        , private val navController: NavController
) : RecyclerView.Adapter<PurchaseHistoryAdapter.PurchaseHistoryViewHolder>() {
    class PurchaseHistoryViewHolder (val binding: ItemHistoryuserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchaseHistoryViewHolder {
        val bindingPurchase = ItemHistoryuserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PurchaseHistoryViewHolder(bindingPurchase)
    }

    override fun getItemCount(): Int = purchaseList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PurchaseHistoryViewHolder, position: Int) {
        val currentUser = UserService.getCurrentUser()!!
        val purchase = purchaseList[position]
        val bind = holder.binding
        val packageName = PackageRepository.getById(purchase.packageId)
        bind.tvHistoryWelcomeMessage.text = "Dear ${currentUser.name}. This is your travel log: "
        bind.tvHistoryPackageName.text = "Package Purchased: ${packageName.name}"
        bind.tvHistoryPurchaseCode.text = "Purchase Code: ${purchase.id}"
        bind.tvHistoryPurchaseDate.text = "Purchase Date: ${purchase.createdDate}"
        bind.tvHistoryPurchasePrice.text = "Total Price: ${purchase.amount}"

        initRecyclerPhoto(bind,packageName)


        bind.btnSelectInvoice.setOnClickListener {
            selectPurchase(purchase)
        }
    }

    private fun initRecyclerPhoto(bind: ItemHistoryuserBinding, packageName: TourPackage) {
        val linearLayoutManager = LinearLayoutManager(bind.root.context)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        bind.rvHistory.layoutManager = linearLayoutManager
        bind.rvHistory.adapter = HistoryPhotoAdapter(packageName.destination.pictures,navController)

    }


}
