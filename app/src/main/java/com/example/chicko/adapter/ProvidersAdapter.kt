package com.example.chicko.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chicko.R
import com.example.chicko.activities.ServiceActivity
import com.example.chicko.data.ProviderData


class ProvidersAdapter(
    private val context: Context,
    private val values: List<ProviderData>
) : RecyclerView.Adapter<ProvidersAdapter.ViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an ProviderData object.
    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.provider_item, parent, false)

        return ViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.textView.text = item.name
        holder.imageView.setImageResource(item.BannerRid)

        // Assigns a [OnClickListener] to the button contained in the [ViewHolder]
        holder.view.setOnClickListener {
            // Create an action from WordList to DetailList
            // using the required arguments
            val intent = Intent(context, ServiceActivity::class.java)
            intent.putExtra(ServiceActivity.SERVICE_ID, item.id)
            context.startActivity(intent)
        }
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = values.size
}