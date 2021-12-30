package com.example.chicko.ui

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.chicko.activities.ServiceActivity
import com.example.chicko.data.Database
import com.example.chicko.databinding.FragmentHomeBinding
import com.google.android.material.textview.MaterialTextView
import com.example.chicko.R as ChickoR


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val searchListView = binding.searchListView
        val searchView = binding.searchView
        val list = Database.Services.map { it.name }

        searchListView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(context, ServiceActivity::class.java)
            intent.putExtra(
                ServiceActivity.SERVICE_ID,
                Database.Services.find { it.name == (view as MaterialTextView).text.toString() }?.ID
            )
            view.context.startActivity(intent)
        }

        val adapter: ArrayAdapter<String> =
            ArrayAdapter(view.context, R.layout.simple_list_item_1, list)

        searchListView.adapter = adapter
        searchListView.visibility = View.GONE
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (query.trim().isEmpty()) {
                    searchListView.visibility = View.GONE
                } else {
                    searchListView.visibility = View.VISIBLE
                }

                if (list.contains(query)) {
                    adapter.filter.filter(query)
                } else {
                    Toast.makeText(context, ChickoR.string.no_match, Toast.LENGTH_LONG).show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                adapter.filter.filter(newText)
                if (newText.trim().isEmpty()) {
                    searchListView.visibility = View.GONE
                } else {
                    searchListView.visibility = View.VISIBLE
                }
                return false
            }
        })
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}