package com.example.tourapp.ui

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.tourapp.R
import com.example.tourapp.databinding.FragmentAboutAsBinding

class AboutAsFragment : Fragment() {

    private lateinit var binding: FragmentAboutAsBinding
    private lateinit var sound: MediaPlayer

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as? AppCompatActivity)?.supportActionBar?.title = " TourApp - The borbotones"
        binding = FragmentAboutAsBinding.inflate(inflater,container,false)

        val aboutUsTitulo = binding.tvAboutUsTitle
        val appVersion = binding.tvInfoVersion
        val poweredBy = binding.tvPoweredby
        val aboutUsMini = binding.textView2
        sound = MediaPlayer.create(requireContext(), R.raw.besharpsbabyonboard)
        sound.start()


        aboutUsTitulo.text = "About TourApp"
        appVersion.text =
            "App Version 3.3.1 | Patch 1\nBuild Number: 20231128.331\nBuild on November 29, 2023\n" +
                    "Development Staff:\nBarzabal Cristian\nMenicucci Giuliana \nRodríguez Sofia \nPezet Gabriel"

        poweredBy.text = "Conceived and Designed By Los Borbotones\nDeveloped By Los Borbotones\n" +
                "Powered By Android Studio Giraffe | Teaching Staff of Mobile Programming I\nCopyright © 2022–2023 Google"

        aboutUsMini.text = "Version 3.3.1 TourApp UNLAM ABOUT US"

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        sound.stop()
        sound.release()


    }
}