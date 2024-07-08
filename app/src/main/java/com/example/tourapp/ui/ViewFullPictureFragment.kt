package com.example.tourapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.tourapp.databinding.FragmentViewFullPictureBinding
import com.example.tourapp.repositories.UserService
import com.squareup.picasso.Picasso

class ViewFullPictureFragment : Fragment() {

    private lateinit var binding: FragmentViewFullPictureBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as? AppCompatActivity)?.supportActionBar?.hide()
        binding = FragmentViewFullPictureBinding.inflate(inflater,container,false)
        Picasso.get()
            .load(UserService.getCurrentImage())
            .into(binding.imageFull)
        return binding.root
    }

}