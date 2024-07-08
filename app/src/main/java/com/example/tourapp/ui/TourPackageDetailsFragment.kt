package com.example.tourapp.ui

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourapp.adapters.PackageDetailAdapter
import com.example.tourapp.data.TourPackage
import com.example.tourapp.databinding.FragmentTourPackageDetailsBinding
import com.example.tourapp.repositories.UserService
import java.util.Locale


class TourPackageDetailsFragment : Fragment(), TextToSpeech.OnInitListener {

    private lateinit var textToSpeech: TextToSpeech
    private lateinit var binding: FragmentTourPackageDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTourPackageDetailsBinding.inflate(inflater,container,false)
        (activity as? AppCompatActivity)?.supportActionBar?.title = " TourApp - Destination details. "

        textToSpeech = TextToSpeech(requireContext(), this)
        val currentPackage = UserService.getCurrentPackageDetail()
        val textoAReproducir = currentPackage!!.destination.description

        val nameTourPackage = binding.txTituleDetails
        val detailsTourPackage = binding.tvDescriptionDetails

        binding.tvDescriptionDetails.setOnClickListener {
            reproducirTexto(textoAReproducir)
        }


        nameTourPackage.text = currentPackage.destination.name
        detailsTourPackage.text = currentPackage.destination.description

        initDetailList(currentPackage)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            if (::textToSpeech.isInitialized && textToSpeech.isSpeaking) {
                textToSpeech.stop()
            } else {
                // Si no se está reproduciendo, continuar con el comportamiento predeterminado
                isEnabled = false
                requireActivity().onBackPressed()
            }
        }

        return binding.root
    }

    private fun reproducirTexto(texto: String) {
        if (textToSpeech.isLanguageAvailable(Locale.getDefault()) == TextToSpeech.LANG_AVAILABLE) {
            textToSpeech.speak(texto, TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }

    private fun initDetailList(currentPackage : TourPackage) {
        val linearLayoutManager = LinearLayoutManager(requireContext())
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.rvlistDetail.layoutManager = linearLayoutManager
        binding.rvlistDetail.adapter = PackageDetailAdapter(currentPackage.destination.pictures , findNavController())
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = textToSpeech.setLanguage(Locale.getDefault())

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Handle language not supported or missing data
                Log.e("TextToSpeech", "Language is not supported")
            }
        } else {
            // Handle initialization failure
            Log.e("TextToSpeech", "Initialization failed")
        }
    }



    override fun onDestroyView() {
        // Liberar recursos al salir del fragmento
        if (::textToSpeech.isInitialized) {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
        super.onDestroyView()
    }

}