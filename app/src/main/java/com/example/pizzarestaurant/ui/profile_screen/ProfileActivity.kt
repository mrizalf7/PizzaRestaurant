package com.example.pizzarestaurant.ui.profile_screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.pizzarestaurant.databinding.ActivityProfileBinding
import com.example.pizzarestaurant.ui.home_screen.HomeViewModel
import com.example.pizzarestaurant.ui.menu_list_screen.MenuListActivity
import dagger.hilt.android.AndroidEntryPoint
import com.example.pizzarestaurant.utils.Helper
import com.example.pizzarestaurant.utils.Helper.capitalizeFirstLetter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class ProfileActivity :AppCompatActivity(){

    private val viewModel : ProfileViewModel by viewModels()
    private lateinit var binding : ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
            lifecycleScope.launch {
                viewModel.getUser.collect {
                        binding.cihampelas.text = it?.location
                        binding.asep.text = "Hello, "+it?.username?.capitalizeFirstLetter()
                }
            }
        binding.menuButton.setOnClickListener{
            val intent = Intent(this@ProfileActivity, MenuListActivity::class.java)
            startActivity(intent)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        return true
    }
}