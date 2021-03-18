package com.example.viewpager2

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viewpager2.databinding.ItemKakaoBinding

class SearchItemAdapter(private val context: Context): RecyclerView.Adapter<SearchItemViewHolder>(){
    var datas = mutableListOf<ResponseSearchVideo.Documents>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchItemViewHolder {
        val binding = ItemKakaoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchItemViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount()= datas.size
}
