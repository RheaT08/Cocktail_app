package com.example.cocktail_app

//Lager coctail-objekter fra API-cocktail
data class Cocktail(
    val id: String,
    val type: String,
    val drinkName: String,
    // val ingrendientsList: List<String>,  //sørge for at posisjons-kall skal være på lik linje for ingredients og measurements...
 //   val measuremenstList: List<String>,
    val instructions: String
    )