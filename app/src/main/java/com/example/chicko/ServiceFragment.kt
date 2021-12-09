package com.example.chicko

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chicko.databinding.ServicePageLayoutBinding

class ServiceFragment : Fragment() {
     private var _binding: ServicePageLayoutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ServicePageLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.addressTextview.text = "فلان جا، خیابان فلان"
        binding.phoneTextview.text = "فلان جا، خیابان فلان"
        binding.rateTextview.text = "فلان جا، خیابان فلان"
        binding.scoreTextView.text = "4.5 / 5"
        binding.infoTextview.text = "123 رای | 12 نظر"
    }
}