package com.example.pollum.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.pollum.data.PhotoData
import com.example.pollum.databinding.FragmentDetailBinding

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

        val photoData = requireArguments().getParcelable<PhotoData>(ARG_PHOTO_DATA)

        photoData?.let {
            // Display the photo details
            binding.detailTitle.text = it.title
            binding.detailDesc.text = it.description

            // Load and display the photo image
            Glide.with(requireContext())
                .load(it.photoUrl)
                .into(binding.detailImg)
        }
    }

    companion object {
        private const val ARG_PHOTO_DATA = "arg_photo_data"

        fun newInstance(photoData: PhotoData): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle().apply {
                putParcelable(ARG_PHOTO_DATA, photoData)
            }
            fragment.arguments = args
            return fragment
        }
    }
}