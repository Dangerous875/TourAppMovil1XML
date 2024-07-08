package com.example.tourapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tourapp.R
import com.example.tourapp.databinding.ItemDetailtourpackageBinding
import com.example.tourapp.repositories.UserService
import com.squareup.picasso.Picasso

class PackageDetailAdapter(private val listPictures: List<String>,private val findNavController: NavController):RecyclerView.Adapter<PackageDetailAdapter.PackageDetailViewHolder>() {
    class PackageDetailViewHolder (val binding: ItemDetailtourpackageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageDetailViewHolder {
        val binding = ItemDetailtourpackageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PackageDetailViewHolder(binding)
    }

    override fun getItemCount(): Int = listPictures.size

    override fun onBindViewHolder(holder: PackageDetailViewHolder, position: Int) {
        val item = listPictures[position]
        val bind = holder.binding

        Picasso.get()
            .load(item)
            .into(bind.imageView)

        bind.imageView.setOnClickListener {
            UserService.setCurrentImage(item)
            findNavController.navigate(R.id.action_tourPackageDetailsFragment_to_viewFullPictureFragment)
        }


    }


}