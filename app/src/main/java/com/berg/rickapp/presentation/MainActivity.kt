package com.berg.rickapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.berg.rickapp.databinding.ActivityMainBinding
import com.berg.rickapp.navigation.impl.TabsFragment
import com.berg.rickapp.navigation.impl.provider.NavigationFragmentProvider

class MainActivity : AppCompatActivity(), NavigationFragmentProvider {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun getNavigationFragment(): TabsFragment? {
        val hostFragment =
            supportFragmentManager.findFragmentById(com.berg.rickapp.navigation.impl.R.id.root_nav_host) as NavHostFragment
        return hostFragment.childFragmentManager.fragments
            .filterIsInstance<TabsFragment>()
            .firstOrNull()
    }

    override fun getRootNavController(): NavController {
        return findNavController(com.berg.rickapp.navigation.impl.R.id.root_nav_host)
    }
}