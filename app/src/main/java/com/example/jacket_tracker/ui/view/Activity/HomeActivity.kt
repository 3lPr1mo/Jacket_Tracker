package com.example.jacket_tracker.ui.view.Activity

import android.os.Bundle
import android.widget.FrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.ui.AppBarConfiguration
import com.example.jacket_tracker.R
import com.example.jacket_tracker.databinding.ActivityHomeBinding
import com.example.jacket_tracker.ui.view.addJacket.Add_Menu
import com.example.jacket_tracker.ui.view.home.HomeFragment
import com.example.jacket_tracker.ui.view.inventory.InventoryHistory
import com.example.jacket_tracker.ui.view.statistics.Statistics_view

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var fragmentContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        fragmentContainer = binding.fragmentContainer

        //val navController = findNavController(R.id.nav_host_fragment_activity_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
                R.id.navigation_statistics
            )
        )


        val homeFragment = HomeFragment()
        setFragment(homeFragment)

        val nav : BottomNavigationView = binding.navView
        nav.setOnItemSelectedListener {
            when (it.itemId){
                R.id.navigation_home ->{   //fragment home
                    val homeFragment = HomeFragment()
                    setFragment(homeFragment)
                    true
                }
                R.id.navigation_dashboard->{ //inventory
                    val inventory = InventoryHistory()
                    setFragment(inventory)
                    true
                }
                R.id.navigation_notifications->{ // add jacket
                    val addjacket = Add_Menu()
                    setFragment(addjacket)
                    true
                }
                R.id.navigation_statistics ->{ // statistics
                    val statistics = Statistics_view()
                    setFragment(statistics)
                    true
                }
                else -> {false}
            }
        }

        //setupActionBarWithNavController(navController, appBarConfiguration)
        //navView.setupWithNavController(navController)
    }

    private fun setFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(fragmentContainer.id, fragment)
            .commit()
    }
}