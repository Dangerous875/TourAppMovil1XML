package com.example.tourapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourapp.adapters.PurchaseHistoryAdapter
import com.example.tourapp.data.Purchase
import com.example.tourapp.databinding.FragmentPurchaseHistoryBinding
import com.example.tourapp.repositories.PurchaseRepository
import com.example.tourapp.repositories.UserService


class PurchaseHistoryFragment : Fragment() {

    private lateinit var binding: FragmentPurchaseHistoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as? AppCompatActivity)?.supportActionBar?.title = " TourApp - Purchase history."
        binding = FragmentPurchaseHistoryBinding.inflate(inflater,container,false)

        initRecyclerPurchase()

        return binding.root
    }

    private fun initRecyclerPurchase() {

        val selectClientClickListerMakeAPurchase = { purchase : Purchase ->
            Toast.makeText(requireContext(), "Invoice CodeRef.${purchase.userId}-${purchase.id} has been downloaded", Toast.LENGTH_SHORT).show()
        }
        val linearLayoutManager = LinearLayoutManager(requireContext())
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerViewHistory.layoutManager = linearLayoutManager
        binding.recyclerViewHistory.adapter = PurchaseHistoryAdapter(
            PurchaseRepository.getPurchasesHistoryCurrenUser(UserService.getCurrentUser()!!),selectClientClickListerMakeAPurchase,findNavController()
        )
    }

}