package com.example.tourapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.tourapp.databinding.FragmentShowMoneyCurrentUserBinding
import com.example.tourapp.repositories.UserService

class ShowMoneyCurrentUserFragment : Fragment() {

    private lateinit var binding: FragmentShowMoneyCurrentUserBinding
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as? AppCompatActivity)?.supportActionBar?.title = " TourApp - User money. "
        binding = FragmentShowMoneyCurrentUserBinding.inflate(inflater,container,false)

        val userMoney = binding.tvUserMoney
        val currentUser = UserService.getCurrentUser()
        val money = binding.etCurrentMoneyUser
        money.setText(currentUser!!.money.toString())



        userMoney.text = "Welcome ${currentUser.name} ${currentUser.surname}\n\nThis is your current account balance: "
        return binding.root
    }

}