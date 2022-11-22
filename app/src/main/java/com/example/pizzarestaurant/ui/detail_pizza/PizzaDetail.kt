package com.example.pizzarestaurant.ui.detail_pizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pizzarestaurant.databinding.ActivityDetailBinding
import com.example.pizzarestaurant.ui.order_detail.OrderDetailActivity

class PizzaDetail : AppCompatActivity() {

    companion object{
        const val EXTRA_pizzaName = "extra_name"
        const val EXTRA_pizzaPhoto = "extra_photo"
        const val EXTRA_pizzaDesc1 = "extra_desc1"
        const val EXTRA_pizzaDesc2 = "extra_desc2"
        const val EXTRA_pizzaPrice = "extra_price"
    }

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        binding.pizzaName.text =  intent.getStringExtra(EXTRA_pizzaName)
        val pizzaPhoto =  intent.getStringExtra(EXTRA_pizzaPhoto)
        Glide.with(this)
            .load(pizzaPhoto)
            .apply(RequestOptions())
            .into(binding.pizzaPicture)
        binding.pizzaDescription.text =  intent.getStringExtra(EXTRA_pizzaDesc2)
        binding.pizzaPrice1.text =  intent.getStringExtra(EXTRA_pizzaPrice)

        binding.backButton.setOnClickListener{
            onBackPressed()
        }
        binding.orderButton.setOnClickListener{
            val orderedFood = intent.getStringExtra(EXTRA_pizzaName)
            val intent = Intent(this, OrderDetailActivity::class.java)
            intent.putExtra(OrderDetailActivity.orderedFoodExtra,orderedFood)
            startActivity(intent)
        }
    }
}