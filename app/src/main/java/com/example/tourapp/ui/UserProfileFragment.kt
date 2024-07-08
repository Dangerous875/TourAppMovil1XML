package com.example.tourapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.tourapp.databinding.FragmentUserProfileBinding
import com.example.tourapp.repositories.PurchaseRepository
import com.example.tourapp.repositories.UserRepository
import com.example.tourapp.repositories.UserService

class UserProfileFragment : Fragment() {


    private lateinit var binding: FragmentUserProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        (activity as? AppCompatActivity)?.supportActionBar?.title = " TourApp - User Profile"
        binding = FragmentUserProfileBinding.inflate(inflater,container,false)


        val userProfileName = binding.tvUserProfileName
        val userProfileSurname = binding.tvUserProfileSurname
        val userProfileAccount = binding.tvUserProfileAccount
        val userProfileImage = binding.tvImageViewUserProfile
        val userProfilePurchase = binding.tvUserProfilePurchases

        val currentUser = UserService.getCurrentUser()
        userProfileName.text = currentUser!!.name
        userProfileSurname.text = currentUser.surname
        userProfileAccount.text = currentUser.createdDate
        userProfilePurchase.text = PurchaseRepository.getPurchasesHistoryCurrenUser(currentUser).size.toString()
        val fullName = "${currentUser.name} ${currentUser.surname}"
        val photoResource = UserRepository.getPhotoResource(fullName)
        userProfileImage.setImageResource(photoResource)

        return binding.root
    }


}