package com.example.work.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.work.databinding.FragmentDetailBinding
import com.example.work.presentation.data.Anime

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        animeModel?.let {
            ivFragmentDetail.setImageResource(it.image)
            tvNameFargmentDetail.text = it.name
            tvYearFargmentDetail.text = it.year
        }
    }

    companion object {
        var animeModel: Anime? = null
    }
}