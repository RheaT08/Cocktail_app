package com.example.cocktail_app

import com.google.gson.annotations.SerializedName

data class Drinks(
    @SerializedName(value ="drinks")
    val cocktailList: List<Cocktail>
)


//Lager cocktail-objekter fra API-cocktail
data class Cocktail(
    val idDrink: String,
    val strDrink: String,
    val strInstructions: String

    //INGRENDIENSER


    )

















//FORSKJELL MELLOM JASONARRAY & JASONOBJECT. API cocktail, har begge i formattet sitt.
//Klassen som inneholder arraylisten av Cocktail-objekter. Siden JSON objektet inneholder en array.
// Må vi håndtere dette også, ved å ha en klasse som inneholder denne arraylisten av JSON-filen.