package com.example.cocktail_app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.cocktail_app.Cocktail
import com.example.cocktail_app.MyAdapter
import com.example.cocktail_app.R
import kotlinx.android.synthetic.main.fragment_library.*
import java.lang.reflect.Type
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.android.volley.Request


class Library : Fragment() {

    //Adapter, and greier for display av info om boligene. Håndtering av RecyclerView layouten
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    //MainViewModel
    private lateinit var libraryViewModel : LibraryMainViewModel
    private val model: LibraryMainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Create viewmodel
        libraryViewModel = ViewModelProvider(this).get(LibraryMainViewModel::class.java)

        return inflater.inflate(R.layout.fragment_library, container, false)
    }


    //LIM INN LIST OF COCKTAILS I LINJE 31
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayCocktails()
        getAllCocktails()
    }



    //METHODS

    private fun getAllCocktails(){


        //Instantiate the RequestQueue
        val queue = Volley.newRequestQueue(context)
        val urlCocktail = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s"

        //Request a string response from the provided URL of messages
        val stringRequest = StringRequest( Request.Method.GET, urlCocktail,

            { response ->

                val listType: Type = object : TypeToken<List<Cocktail?>?>() {}.type    //henter ut Message object fra API.
                val cocktail_listen = Gson().fromJson<List<Cocktail>>(response, listType)

                //displayCocktails(cocktail_listen)

            },
            {
                //Hva skjer ved feil, skrives her
            })
        queue.add(stringRequest)

    }



    private fun displayCocktails(/*cocktails: List<Cocktail>*/){

        val cocktailsList = listOf<String>("Martini","Gintonic","asd","asd","liuasd","lasduo","lol")
        viewManager = LinearLayoutManager(requireContext())
        viewAdapter = MyAdapter(cocktailsList)  //oppretter en objekt av MyAdapter klassen min. Parameter en mutablelist.


        recyclerView = cocktail_recyclerview.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            //adapter = viewAdapter
            cocktail_recyclerview.adapter = viewAdapter
        }
    }

    //todo: 1) Adapter 2) Recyclerview 3) Hent in API after its all clear.

}
