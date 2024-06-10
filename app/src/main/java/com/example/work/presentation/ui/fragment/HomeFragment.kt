package com.example.work.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.work.R
import com.example.work.databinding.FragmentHomeBinding
import com.example.work.presentation.data.Anime
import com.example.work.presentation.data.OnItemClickListener
import com.example.work.presentation.ui.adapter.AnimeAdapter

class HomeFragment : Fragment(), OnItemClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val animeAdapter = AnimeAdapter(this)

    private val animeList = mutableListOf(
        Anime(R.drawable.hotimiya, "Horimiya","вышел в 2021 году"),
        Anime(R.drawable.magic, "Magic Battle","вышел в 2020 году"),
        Anime(R.drawable.academia, "My Hero Academy","вышел в 2016 году"),
        Anime(R.drawable.stoune, "Doctor Stoune","вышел в 2019 году"),
        Anime(R.drawable.death, "Death Note","вышел в 2006 году"),
        Anime(R.drawable.hanter, "Hanter x Hanter","вышел в 2007 году"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animeAdapter.setDataAnimeList(animeList)
        binding.rvAnimeHome.adapter = animeAdapter
    }

    override fun onItemClick(anime: Anime) {
        DetailFragment.animeModel = anime
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}