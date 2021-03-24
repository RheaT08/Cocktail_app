package com.example.cocktail_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    companion object {
        //LISTEN MED COCKTAILS
    }

    val libraryFragment = Library.newInstance()
    var randomFragment = Random.newInstance()
    var favoritesFragment = Favorites.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, libraryFragment)
                .commitNow()
        }
    }

}