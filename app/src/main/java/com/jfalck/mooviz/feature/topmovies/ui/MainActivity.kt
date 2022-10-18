package com.jfalck.mooviz.feature.topmovies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.jfalck.mooviz.R
import com.jfalck.mooviz.databinding.ActivityTopMoviesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val navController by lazy { findNavController(R.id.activity_top_movies_nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityTopMoviesBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
    }


}