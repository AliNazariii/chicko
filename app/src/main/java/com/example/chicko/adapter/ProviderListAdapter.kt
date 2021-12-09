package com.example.chicko.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.chicko.ProviderListFragmentDirections
import com.example.chicko.R
import com.example.chicko.model.ProviderItem

class ProviderListAdapter(
    private val context: Context,
    private val dataset: List<ProviderItem>
) : RecyclerView.Adapter<ProviderListAdapter.ProviderItemViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an ProviderItem object.
    class ProviderItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProviderItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.provider_item, parent, false)

        return ProviderItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ProviderItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.titleRId)
        holder.imageView.setImageResource(item.BannerRid)

        // Assigns a [OnClickListener] to the button contained in the [ViewHolder]
        holder.view.setOnClickListener {
            // Create an action from WordList to DetailList
            // using the required arguments
            val action =
                ProviderListFragmentDirections.actionProviderListFragmentToServiceFragment2(id = 2)
            // Navigate using that action
//            holder.view.findNavController().navigate(action)
        }
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
}