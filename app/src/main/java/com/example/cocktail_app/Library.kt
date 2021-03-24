package com.example.cocktail_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_library.*


class Library : Fragment() {
    var myAdapter: MyAdapter? = null

    companion object {
        fun newInstance() = Library()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_library, container, false)
    }


    //LIM INN LIST OF COCKTAILS I LINJE 31
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myAdapter = MyAdapter(listOf())
        cocktails_recyclerview.adapter = myAdapter
        cocktails_recyclerview.layoutManager = LinearLayoutManager(activity)
    }

/*
    override fun onResume() {
        super.onResume()
        updateList(MainActivity.LISTOFALLCOCKTAILS)
    }
*/

/*
    fun updateList()

}*/

}
