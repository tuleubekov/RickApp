package com.berg.rickapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.berg.rickapp.databinding.ActivityMainBinding
import com.berg.rickapp.di.AppComponent

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val component by lazy { AppComponent.get() }
    private val fragmentFactory by lazy { component.getFragmentFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = fragmentFactory
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}