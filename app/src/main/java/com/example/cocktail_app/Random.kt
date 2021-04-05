package com.example.cocktail_app

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.Volley
import com.example.cocktail_app.ui.LibraryMainViewModel
import kotlinx.android.synthetic.main.fragment_random.*

class Random : Fragment() {

    //MainViewModel
    private lateinit var libraryViewModel : LibraryMainViewModel
    private val model: LibraryMainViewModel by activityViewModels()

    //btn

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        generator_btn.setBackgroundColor(Color.CYAN);
        generator_btn.setOnClickListener {
            val intent = Intent(context, Random2::class.java)
            startActivity(intent);
        }

    }



}