package com.example.pizzarestaurant.ui.menu_list_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzarestaurant.databinding.ActivityMenuListBinding
import com.example.pizzarestaurant.domain.model.Pizza
import com.example.pizzarestaurant.utils.Helper.capitalizeFirstLetter
import com.example.pizzarestaurant.utils.PizzaData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MenuListActivity: AppCompatActivity() {


    private val viewModel : MenuListViewModel by viewModels()


    private lateinit var binding : ActivityMenuListBinding
    private lateinit var rvPizzas : RecyclerView
    private var list: ArrayList<Pizza> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMenuListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
            lifecycleScope.launch{
                viewModel.getUser.collect {
                    binding.asep.text = "Hello, "+it?.username?.capitalizeFirstLetter()
                }
            }
        rvPizzas = binding.rvPizzas
        rvPizzas.setHasFixedSize(true)
        list.addAll(PizzaData.listData)
        showRecyclerList()
    }


    private fun showRecyclerList() {
        rvPizzas.layoutManager = LinearLayoutManager(this)
        val listPizzaAdapter = MenuListAdapter(list)
        rvPizzas.adapter = listPizzaAdapter
    }

}