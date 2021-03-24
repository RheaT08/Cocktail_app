package com.example.cocktail_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_random.*

class Random : Fragment() {

    var myAdapter: MyAdapter? = null

    companion object {
        fun newInstance() = Random()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_random, container, false)
    }

    //LIM INN LISTE AV RANDOM I LINJE 28
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myAdapter = MyAdapter(listOf())
        random_recyclerview.adapter = myAdapter
        random_recyclerview.layoutManager = LinearLayoutManager(activity)
    }

    override fun onResume() {
        super.onResume()
        updateRandomList()
    }

    fun updateRandomList(){

    }


}