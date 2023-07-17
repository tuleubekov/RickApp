package com.berg.rickapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.berg.rickapp.databinding.ActivityMainBinding
import com.berg.rickapp.navigation.NavigationFragmentProvider

class MainActivity : AppCompatActivity(), NavigationFragmentProvider {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun getNavigationFragment(): MainFragment? {
        return supportFragmentManager.fragments
            .filterIsInstance<MainFragment>()
            .firstOrNull()
    }
}