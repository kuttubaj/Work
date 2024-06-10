package com.example.work.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.work.databinding.ItemAnimeBinding
import com.example.work.presentation.data.Anime
import com.example.work.presentation.data.OnItemClickListener

class AnimeAdapter(
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    private var animeList = mutableListOf<Anime>()

    fun setDataAnimeList(animeList: MutableList<Anime>) {
        this.animeList = animeList
    }

    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onItemClickListener.onItemClick(animeList[layoutPosition])
            }
        }

        fun onBind(anime: Anime) {
            binding.ivImage.setImageResource(anime.image)
            binding.tvText.text = anime.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val binding = ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.onBind(animeList[position])
    }
}