package com.example.cocktail_app.ui

import androidx.lifecycle.ViewModel
import com.example.cocktail_app.Cocktail
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.lang.reflect.Type

class LibraryMainViewModel :  ViewModel() {


    fun getCocktailsAPI(
        queue: RequestQueue,
        successCallback: (List<Cocktail>) -> Unit,
        errorCallback: () -> Unit,
    ) {
        val url = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            { response ->
                val listType: Type = object : TypeToken<List<Cocktail?>?>() {}.type
                val chatMessages = Gson().fromJson<List<Cocktail>>(response, listType)

                successCallback(chatMessages)
            },
            {
                errorCallback()
            }
        )

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

}