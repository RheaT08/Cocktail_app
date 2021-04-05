package com.example.cocktail_app

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.Volley
import com.example.cocktail_app.ui.LibraryMainViewModel
import kotlinx.android.synthetic.main.cocktail_card.*
import kotlinx.android.synthetic.main.fragment_favorites.*
import kotlinx.android.synthetic.main.fragment_library.*


class Favorites : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var libraryViewModel: LibraryMainViewModel
    private val model: LibraryMainViewModel by activityViewModels()

    companion object {
        fun newInstance() = Favorites()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        libraryViewModel = ViewModelProvider(this).get(LibraryMainViewModel::class.java)
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getLibraryCocktails()
    }


    private fun getLibraryCocktails(){
        libraryViewModel.getCocktailsAPI(
            Volley.newRequestQueue(context),
            {
                getCocktails ->
                displayCocktail(MainActivity.favoriteDrinks)
            },
            {

            }
        )
    }

    private fun displayCocktail(myDrinks: List<Cocktail>) {
        viewManager = LinearLayoutManager(requireContext())
        viewAdapter = MyAdapter(myDrinks)
        recyclerView = favorites_recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            favorites_recyclerview.adapter = viewAdapter
        }
    }
}
