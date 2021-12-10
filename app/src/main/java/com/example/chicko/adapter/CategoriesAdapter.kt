package com.example.chicko.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chicko.R
import com.example.chicko.data.CategoryData


class CategoriesAdapter(
    private val context: Context,
    private val values: List<CategoryData>
) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an CategoryData object.
    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val label: TextView = view.findViewById(R.id.label)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item, parent, false)

        return ViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.label.text = item.label

        // Assigns a [OnClickListener] to the button contained in the [ViewHolder]
//        holder.view.setOnClickListener {
//            // Create an action from WordList to DetailList
//            // using the required arguments
//            val intent = Intent(context, ServiceActivity::class.java)
//            context.startActivity(intent)
//        }
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = values.size
}