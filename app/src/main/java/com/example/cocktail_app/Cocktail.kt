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
    val strInstructions: String,
    val strDrinkThumb: String,

    //INGRENDIENSER - midlertidig løsning???
    private val strIngredient1 : String?,
    private val strIngredient2 : String?,
    private val strIngredient3 : String?,
    private val strIngredient4 : String?,
    private val strIngredient5 : String?,
    private val strIngredient6 : String?,
    private val strIngredient7 : String?,
    private val strIngredient8 : String?,
    private val strIngredient9 : String?,
    private val strIngredient10 : String?,
    private val strIngredient11 : String?,
    private val strIngredient12 : String?,
    private val strIngredient13 : String?,
    private val strIngredient14 : String?,
    private val strIngredient15 : String?,


    //MEASURMENTS
    private val strMeasure1 : String?,
    private val strMeasure2 : String?,
    private val strMeasure3 : String?,
    private val strMeasure4 : String?,
    private val strMeasure5 : String?,
    private val strMeasure6 : String?,
    private val strMeasure7 : String?,
    private val strMeasure8 : String?,
    private val strMeasure9 : String?,
    private val strMeasure10 : String?,
    private val strMeasure11 : String?,
    private val strMeasure12 : String?,
    private val strMeasure13 : String?,
    private val strMeasure14 : String?,
    private val strMeasure15 : String?

    )
   //INNE I COCKTAIL-KLASSEN
{

      fun getIngredients() : MutableList<String>{

        val finalList = mutableListOf<String>()

        val ingredienser = mutableListOf<String?>(
                strIngredient1,
                strIngredient2,
                strIngredient3,
                strIngredient4,
                strIngredient5,
                strIngredient6,
                strIngredient7,
                strIngredient8,
                strIngredient9,
                strIngredient10,
                strIngredient11,
                strIngredient12,
                strIngredient13,
                strIngredient14,
                strIngredient15
        )

        val measurements = mutableListOf<String?>(
                strMeasure1,
                strMeasure2,
                strMeasure3,
                strMeasure4,
                strMeasure5,
                strMeasure6,
                strMeasure7,
                strMeasure8,
                strMeasure9,
                strMeasure10,
                strMeasure11,
                strMeasure12,
                strMeasure13,
                strMeasure14,
                strMeasure15
        )


        for(vare in ingredienser){
            if(vare != null){
                finalList.add(vare)
            }
        }


          val tempListe = mutableListOf<String>()
          for (measurement in measurements){
              if(measurement != null){
                  tempListe.add(measurement)
              }
          }

          var i = 0
          for(measurement in tempListe){
              finalList[i] = finalList[i]+" "+ tempListe[i]
              i++
          }

        return finalList
    }
}








/*  Rydigere kode

      fun getIngredients() : MutableList<String>{

        val finalList = mutableListOf<String>()

        val ingredienser = mutableListOf<String?>()
        val measurement = mutableListOf<String?>()

        var inkrement = 1
        var l = "$strIngredient1"  //strIngredient1
          var a = "$l" //strIngredient1

        while (inkrement != 15){

            var vare = a

            ingredienser.add(vare)
            inkrement++
        }

        //var x = 0
        //var strMeasure = $run { "strIngredient$x" }


        for(vare in ingredienser){
            if(vare != null){
                finalList.add(vare)
            }
        }

        return finalList
    }
 */



//FORSKJELL MELLOM JASONARRAY & JASONOBJECT. API cocktail, har begge i formattet sitt.
//Klassen som inneholder arraylisten av Cocktail-objekter. Siden JSON objektet inneholder en array.
// Må vi håndtere dette også, ved å ha en klasse som inneholder denne arraylisten av JSON-filen.