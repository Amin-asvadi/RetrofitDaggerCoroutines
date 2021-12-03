package com.devillas.daggerhiltandretrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.devillas.daggerhiltandretrofit.databinding.ImageLayoutBinding
import com.devillas.daggerhiltandretrofit.model.ImageItems

class ImageAdapter :RecyclerView.Adapter<ImageAdapter.ImageViewHolder>(){

    inner class ImageViewHolder
        (val binding:ImageLayoutBinding)
        :RecyclerView.ViewHolder(binding.root)

    private val diffCallback  = object :DiffUtil.ItemCallback<ImageItems>(){
        override fun areItemsTheSame(oldItem: ImageItems, newItem: ImageItems): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ImageItems, newItem: ImageItems): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this,diffCallback)
    fun submitList(list: List<ImageItems>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
      return ImageViewHolder(
          ImageLayoutBinding.inflate(
              LayoutInflater.from(parent.context),parent,false
          )
      )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
      val currImage = differ.currentList[position]
        holder.binding.apply {
            description.text = currImage.description
            val imageLink = currImage.urls.full
            image.load(imageLink){
                crossfade(true)
                crossfade(1600)
            }
        }
    }

    override fun getItemCount(): Int {
      return  differ.currentList.size
    }


}