package com.example.chicko.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chicko.adapter.ProvidersAdapter
import com.example.chicko.data.ProvidersDataSource
import com.example.chicko.databinding.FragmentProvidersBinding

class ProvidersFragment : Fragment() {

    private var _binding: FragmentProvidersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProvidersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.providersRecyclerView
        val dataSet = ProvidersDataSource.loadProviderItems()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ProvidersAdapter(view.context, dataSet)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}