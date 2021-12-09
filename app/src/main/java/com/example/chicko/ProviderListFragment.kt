package com.example.chicko

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chicko.adapter.ProviderListAdapter
import com.example.chicko.data.ProviderItemsDataSource
import com.example.chicko.databinding.FragmentProviderListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ProviderListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProviderListFragment : Fragment() {
    private var _binding: FragmentProviderListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Retrieve and inflate the layout for this fragment
        _binding = FragmentProviderListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        val dataSet = ProviderItemsDataSource().loadProviderItems()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ProviderListAdapter(view.context, dataSet)
    }

    /**
     * Frees the binding object when the Fragment is destroyed.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}