package com.example.tourapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourapp.R
import com.example.tourapp.adapters.TourPackageListAdapter
import com.example.tourapp.data.TourPackage
import com.example.tourapp.databinding.FragmentTourPackageListBinding
import com.example.tourapp.repositories.PackageRepository

class TourPackageListFragment : Fragment() {

    private lateinit var binding: FragmentTourPackageListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as? AppCompatActivity)?.supportActionBar?.title =  " TourApp - TourPackageList. "
        binding = FragmentTourPackageListBinding.inflate(inflater,container,false)

        initTourPackageList()
        return binding.root
    }

    private fun initTourPackageList() {

        val selectClickExit = {
            val action = TourPackageListFragmentDirections.actionTourPackageListFragmentToMenuPrincipalFragment()
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.menuPrincipalFragment, true)
                .build()
            findNavController().navigate(action, navOptions)
        }

        val selectClickOnTourPackageDetails = { _: TourPackage ->
            findNavController().navigate(R.id.action_tourPackageListFragment_to_tourPackageDetailsFragment)
        }

        val selectClientClickListerBuyAPurchase = { _: TourPackage ->
            findNavController().navigate(R.id.action_tourPackageListFragment_to_purchasePackageFragment)
        }
        val linearLayoutManager = LinearLayoutManager(requireContext())
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerViewTourPackage.layoutManager = linearLayoutManager
        binding.recyclerViewTourPackage.adapter = TourPackageListAdapter(PackageRepository.getPackagesList(),
            selectClickOnTourPackageDetails,
            selectClientClickListerBuyAPurchase,
            selectClickExit,findNavController())
    }

}