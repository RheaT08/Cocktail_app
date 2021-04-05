package com.example.cocktail_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktail_app.ui.Library
import com.squareup.picasso.Picasso

class MyAdapter(private val libContext: Context, private var cocktailDataset: List<Cocktail>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

//TODO: Sette ingredients og measurement i textviews. Finne hvordan man progmatisk lager ny textview utifra liste størrelse.
//TODO: Finne ut hvordan du henter API bilder, og erstatte martini-ikonet på ImageView.
//TODO: Enklere "samrtere" kode når det gjelder å legge til variablene og inkrementere .


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name_textview: TextView = view.findViewById(R.id.name_textview)
        val instruction_textview: TextView = view.findViewById(R.id.instruction_textview)
        val ingrediens_textview: TextView = view.findViewById(R.id.ingrediens_textview)
        val imageCocktail : ImageView = view.findViewById(R.id.cocktail_ImageView)

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

        //TODO: Drinkname, ingrediens + measurements, instructions, picture.

        //cocktail_names
        viewHolder.name_textview.text = cocktailDataset[position].strDrink
        viewHolder.ingrediens_textview.text = cocktailDataset[position].getIngredients().toString()
        viewHolder.instruction_textview.text = cocktailDataset[position].strInstructions
        val imageUri = cocktailDataset[position].strDrinkThumb
        Picasso.with(libContext).load(imageUri).into(viewHolder.imageCocktail)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = cocktailDataset.size

    fun updateData(newData: List<Cocktail>) {
        cocktailDataset = newData
        notifyDataSetChanged()
    }


}