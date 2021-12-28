package com.example.consumingdatawithrecyclerview.overview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.consumingdatawithrecyclerview.databinding.ItemListBinding
import com.example.consumingdatawithrecyclerview.network.Image
import com.example.consumingdatawithrecyclerview.overview.GalleryImageAdapter.GalleryImageViewHolder

class GalleryImageAdapter: androidx.recyclerview.widget.ListAdapter<Image, GalleryImageViewHolder>(DiffCallback) {


    class GalleryImageViewHolder(private var binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(image: Image) {
            binding.image = image
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.id ==  newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryImageViewHolder {
        return GalleryImageViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: GalleryImageViewHolder, position: Int) {
        val imageGallery = getItem(position)
        holder.bind(imageGallery)
    }
}