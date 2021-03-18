package com.example.viewpager2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viewpager2.databinding.ItemKakaoBinding

class SearchItemViewHolder(val binding: ItemKakaoBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: ResponseSearchVideo.Documents) {
        binding.itemTitle.text = data.title
        Glide.with(binding.root).load(data.thumbnail).into(binding.itemThumbnail)
    }
}