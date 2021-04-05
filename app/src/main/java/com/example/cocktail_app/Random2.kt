package com.example.cocktail_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.toolbox.Volley
import com.example.cocktail_app.ui.LibraryMainViewModel

//Her skal random cocktail hentes og vises
class Random2 : AppCompatActivity() {


    //MainViewModel
    private lateinit var libraryViewModel : LibraryMainViewModel
   // private val model: LibraryMainViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random2)
    }


    private fun getRandomcocktail(){

        libraryViewModel.getRandomCocktail(
            Volley.newRequestQueue(this),

            //IF Kall is successfull, get Cocktails.
            { getCocktails ->
                //displayCocktails(getCocktails.cocktailList)

            },
            {
                //Noe gikk galt...
            }
        )
    }

    private fun display(){



    }



}