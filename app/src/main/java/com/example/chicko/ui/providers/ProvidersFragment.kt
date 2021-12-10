package com.example.chicko.ui.providers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chicko.adapter.ProviderListAdapter
import com.example.chicko.data.ProviderItemsDataSource
import com.example.chicko.databinding.FragmentProvidersBinding

class ProvidersFragment : Fragment() {

    private lateinit var providersViewModel: ProvidersViewModel
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
        providersViewModel =
            ViewModelProvider(this).get(ProvidersViewModel::class.java)

        _binding = FragmentProvidersBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textDashboard
//        providersViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.providersRecyclerView
        val dataSet = ProviderItemsDataSource().loadProviderItems()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ProviderListAdapter(view.context, dataSet)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}