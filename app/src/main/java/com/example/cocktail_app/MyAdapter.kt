package com.example.cocktail_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val cocktailDataset: List<String>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name_textview: TextView = view.findViewById(R.id.name_textview)
        val instruction_textview: TextView = view.findViewById(R.id.instruction_textview)

        init {
            // Define click listener for the ViewHolder's View.
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.cocktail_card, viewGroup, false) as View

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        //cocktail_names
        viewHolder.name_textview.text = cocktailDataset[position]
       //viewHolder.instruction_textview.text = cocktailDataset[position].instructions
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = cocktailDataset.size



}