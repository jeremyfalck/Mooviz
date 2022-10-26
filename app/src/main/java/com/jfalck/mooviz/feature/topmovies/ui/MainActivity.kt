package com.jfalck.mooviz.feature.topmovies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.jfalck.mooviz.R
import com.jfalck.mooviz.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val navController by lazy {
        (supportFragmentManager
            .findFragmentById(R.id.activity_top_movies_nav_host_fragment) as NavHostFragment)
            .findNavController()
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).also {
            binding = it
            setContentView(it.root)
        }

        binding.bottomNav.setupWithNavController(navController)

        initView()
    }

    private fun initView() {
        binding.bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_item_trending -> {
                    navController.navigate(R.id.topMoviesFragment)
                    true
                }
                R.id.menu_item_favorites -> {
                    navController.navigate(R.id.favoriteMoviesFragment)
                    true
                }
                else -> false
            }
        }
        binding.bottomNav.setOnItemReselectedListener {
            //TODO reload fragments contents
        }
    }


}