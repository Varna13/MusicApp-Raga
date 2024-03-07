package com.example.raga

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Color
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.core.view.drawToBitmap
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.raga.databinding.ItemMusicBinding

class MyAdapter(
    val context: Activity,
    val dataList: List<Data>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemMusicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //populate the data into the view
        holder.bind(dataList[position])
    }

    inner class MyViewHolder(private val binding: ItemMusicBinding): RecyclerView.ViewHolder(binding.root) {
        //create the view in case the layout manager fails to crete view for the data
        fun bind(dataList: Data){
            binding.tvTitle.text = dataList.title
            Glide.with(context)
                .load(dataList.album.cover)
                .into(binding.ivMusicCover)

            val mediaPlayer = MediaPlayer.create(context, dataList.preview.toUri())
            binding.ibPlay.setOnClickListener {
                mediaPlayer.start()
            }
            binding.ibPause.setOnClickListener {
                mediaPlayer.pause()
            }
        }
    }
}