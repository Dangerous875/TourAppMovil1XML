package com.example.tourapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tourapp.R
import com.example.tourapp.data.TourPackage
import com.example.tourapp.databinding.ItemTourpackageBinding
import com.example.tourapp.repositories.UserService
import com.squareup.picasso.Picasso

class TourPackageListAdapter(
    private val listTourPackage: List<TourPackage>
    , val selectDetail: (TourPackage) -> Unit
    , val selectPurchasePackage: (TourPackage) -> Unit
    , val selectExit: () -> Unit
    , private val findNavController: NavController
) : RecyclerView.Adapter<TourPackageListAdapter.TourPackageListViewHolder>() {

    class TourPackageListViewHolder (val binding: ItemTourpackageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourPackageListViewHolder {
        val binding = ItemTourpackageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TourPackageListViewHolder(binding)
    }

    override fun getItemCount(): Int = listTourPackage.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: TourPackageListViewHolder, position: Int) {
        val tourPackage = listTourPackage[position]
        val bind = holder.binding

        bind.txtPackageName.text = tourPackage.destination.name
        bind.tvName.text = "Package: ${tourPackage.name}"
        bind.tvPrice.text = "Price: ${tourPackage.price}"
        bind.ratingBar.rating = tourPackage.stars.toFloat()
        bind.tvDuration.text = "Duration: ${tourPackage.duration} hours"
        bind.tvTransportType.text = "Transport: ${tourPackage.transport}"
        Picasso.get()
            .load(tourPackage.logo)
            .into(bind.ivLogoPackage)


        bind.ivLogoPackage.setOnClickListener {
            UserService.setCurrentImage(tourPackage.logo)
            findNavController.navigate(R.id.action_tourPackageListFragment_to_viewFullPictureFragment)
        }

        bind.btnDetailsTourPackage.setOnClickListener {
            selectDetail(tourPackage)
            UserService.setCurrentPackageDetail(tourPackage)

        }



        bind.btnReturn.setOnClickListener {
            selectExit()
        }

        bind.btnBuyPackage.setOnClickListener {
            selectPurchasePackage(tourPackage)
            UserService.setCurrentPackage(tourPackage)

        }
    }
}