package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.databinding.FragmentInventoryBinding
import com.udacity.shoestore.fragment.InventoryFragmentDirections
import com.udacity.shoestore.viewmodel.ShoeListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ShoeListViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        viewModel.title.observe(this, {
            title = it
        })

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.loginFragment, R.id.inventoryFragment))
        val navController = findNavController(R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            menu?.findItem(R.id.logOut)?.isVisible = destination.id == R.id.inventoryFragment
            viewModel.setTitle(destination.label.toString())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menu = menu
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logOut) {
            val navController = findNavController(R.id.nav_host_fragment)
            navController.navigate(InventoryFragmentDirections.actionInventoryFragmentToLoginFragment2())
        }
        return super.onOptionsItemSelected(item)
    }
}
