package com.example.tourapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.tourapp.R
import com.example.tourapp.data.Purchase
import com.example.tourapp.data.TourPackage
import com.example.tourapp.data.User
import com.example.tourapp.databinding.FragmentPurchasePackageBinding
import com.example.tourapp.repositories.PurchaseRepository
import com.example.tourapp.repositories.UserRepository
import com.example.tourapp.repositories.UserService
import java.time.LocalDate

class PurchasePackageFragment : Fragment() {


    private lateinit var binding: FragmentPurchasePackageBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as? AppCompatActivity)?.supportActionBar?.title =
            " TourApp - Purchase confirmation."
        binding = FragmentPurchasePackageBinding.inflate(inflater, container, false)

        val currentPackage = UserService.getCurrentPackage()
        val currentUser = UserService.getCurrentUser()
        val totalAmountToPay: Double
        val commission: Double
        val pair = UserService.calculateAmountToPayForThePackage(currentPackage!!)
        totalAmountToPay = pair.first
        commission = pair.second

        val packageName = binding.tvPackageNamePurchase
        val packagePrice = binding.tvCostPurchase
        val packageCommission = binding.tvCommissionPurchase
        val packageTotal = binding.tvTotalPurchase
        val confirm = binding.btnConfirm
        val cancel = binding.btnCancel

        packageName.text =
            "Package Name: ${currentPackage.name}"
        packagePrice.text =
            "Cost of your selected package is:\n $${currentPackage.price} "
        packageCommission.text =
            "Percentage of fees and taxes added:\n $commission %"
        packageTotal.text =
            "Total price:\n $$totalAmountToPay"


        cancel.setOnClickListener {
            UserService.setCurrentPackage(null)
            val action = PurchasePackageFragmentDirections.actionPurchasePackageFragmentToMenuPrincipalFragment()
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.menuPrincipalFragment, true)
                .build()
            Toast.makeText(requireContext(), "Your purchase has been cancelled.", Toast.LENGTH_LONG).show()
            findNavController().navigate(action, navOptions)
        }


        confirm.setOnClickListener {
            if (currentUser!!.money >= totalAmountToPay) {
                val newPurchase: Purchase =
                    buildNewPurchase(currentPackage, currentUser, totalAmountToPay)
                PurchaseRepository.addNewPurchase(newPurchase)
                UserRepository.modifyMoney(currentUser, totalAmountToPay)
                UserService.setCurrentPackage(null)
                Toast.makeText(requireContext(),"Successful purchase!\nHave a nice trip", Toast.LENGTH_LONG).show()
                val action = PurchasePackageFragmentDirections.actionPurchasePackageFragmentToMenuPrincipalFragment()
                val navOptions = NavOptions.Builder()
                    .setPopUpTo(R.id.menuPrincipalFragment, true)
                    .build()
                findNavController().navigate(action, navOptions)
            }else{
                Toast.makeText(requireContext(),"Not enough money. Select another package", Toast.LENGTH_LONG).show()
            }
        }




        return binding.root
    }

    private fun buildNewPurchase(
        currentPackage: TourPackage,
        currentUser: User?,
        totalAmountToPay: Double
    ): Purchase {
        val lastPurchase = PurchaseRepository.getPurchaseslist().last()
        val id = lastPurchase.id + 1
        val purchase: Purchase
        val userId = currentUser!!.id
        val packageId = currentPackage.id
        val createdDate = LocalDate.now().toString()

        purchase = Purchase(id, userId, packageId, totalAmountToPay, createdDate)

        return purchase
    }

}