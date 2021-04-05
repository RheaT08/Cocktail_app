package com.example.cocktail_app.ui

import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.example.cocktail_app.Cocktail
import com.example.cocktail_app.Drinks
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class LibraryMainViewModel :  ViewModel() {


    fun getCocktailsAPI(
            queue: RequestQueue,
            successCallback: (Drinks) -> Unit,
            errorCallback: () -> Unit,
    ) {
        val url = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
                Request.Method.GET,
                url,
                { response ->
                    //val listType: Type = object : TypeToken<ArrayList<Cocktail?>?>() {}.type
                    //val cocktailListen = Gson().fromJson<ArrayList<Cocktail>>(response, listType)

                    val drinks: Drinks = Gson().fromJson(response,Drinks::class.java)

                    successCallback(drinks)   //sender success-svar dersom kallet blir en suksess.

                },
                {
                    errorCallback()
                }
        )

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }


    fun getRandomCocktail(
            queue: RequestQueue,
            successCallback: (Drinks) -> Unit,
            errorCallback: () -> Unit,
    ) {
        val url = "https://www.thecocktaildb.com/api/json/v1/1/random.php"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
                Request.Method.GET,
                url,
                { response ->

                    val drink: Drinks = Gson().fromJson(response,Drinks::class.java)
                    successCallback(drink)   //sender success-svar dersom kallet blir en suksess.

                },
                {
                    errorCallback()
                }
        )

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }


}


//så hvordan tar jeg stringene jeg vil fra API-et og sette de som verdi i Cocktail-klassen min? Lager cocktail objeketene mine.
//Hvordan etterlater jeg alt annet info som API gir? jeg ikke trenger?