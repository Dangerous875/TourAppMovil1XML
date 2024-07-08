package com.example.tourapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tourapp.R
import com.example.tourapp.databinding.ItemImagehistoryBinding
import com.example.tourapp.repositories.UserService
import com.squareup.picasso.Picasso

class HistoryPhotoAdapter(private val listPictures: List<String>,private val findNavController: NavController) : RecyclerView.Adapter<HistoryPhotoAdapter.HistoryPhotoViewHolder>() {
    class HistoryPhotoViewHolder (val binding: ItemImagehistoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryPhotoViewHolder {
        val binding = ItemImagehistoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HistoryPhotoViewHolder(binding)
    }

    override fun getItemCount(): Int = listPictures.size

    override fun onBindViewHolder(holder: HistoryPhotoViewHolder, position: Int) {
        val item = listPictures[position]
        val bind = holder.binding

        Picasso.get()
            .load(item)
            .into(bind.ivHistoryPurchaseImage)

        bind.ivHistoryPurchaseImage.setOnClickListener {
            UserService.setCurrentImage(item)
            findNavController.navigate(R.id.action_purchaseHistoryFragment_to_viewFullPictureFragment)
        }

    }
}