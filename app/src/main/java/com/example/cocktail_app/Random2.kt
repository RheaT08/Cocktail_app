package com.example.cocktail_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.android.volley.toolbox.Volley
import com.example.cocktail_app.ui.LibraryMainViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_random2.*
import kotlinx.android.synthetic.main.cocktail_card.*

//Her skal random cocktail hentes og vises
class Random2 : AppCompatActivity() {


    //MainViewModel
    private lateinit var libraryViewModel : LibraryMainViewModel

    //private val model: LibraryMainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random2)

        //Create viewmodel
        libraryViewModel = ViewModelProvider(this).get(LibraryMainViewModel::class.java)

        getRandomcocktail()
    }


    private fun getRandomcocktail(){

        libraryViewModel.getRandomCocktail(
            Volley.newRequestQueue(this),

            //IF Kall is successfull, get Cocktails.
            { getCocktails ->
                //displayCocktails(getCocktails.cocktailList)
                display(getCocktails.cocktailList)
            },
            {
                //Noe gikk galt...
            }
        )
    }


    private fun display(cocktail: List<Cocktail>){

        cocktail_textView.text = cocktail[0].strDrink
        ingredienser_textview.text = cocktail[0].getIngredients().toString()
        instruks_textview.text = cocktail[0].strInstructions

        val imageUri = cocktail[0].strDrinkThumb
        Picasso.with(this).load(imageUri).into(cocktail_imageView)
    }
}