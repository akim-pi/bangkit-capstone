package com.example.pollum.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.pollum.R
import com.example.pollum.data.PhotoData
import com.example.pollum.databinding.PageItemBinding

class PageAdapter(
    private val itemList: List<PhotoData>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<PageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PageItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(private val binding: PageItemBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(item: PhotoData) {
            binding.noTitle.text = item.title
            binding.noDesc.text = item.description

            Glide.with(binding.root)
                .load(item.photoUrl)
                .placeholder(R.drawable.imgpollum)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.imgCapture)
        }

        override fun onClick(v: View) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val item = itemList[position]
                listener.onItemClick(item)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(photoData: PhotoData)
    }
}


