package com.example.pizzarestaurant.ui.order_detail


import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.pizzarestaurant.R
import com.example.pizzarestaurant.databinding.ActivityOrderDetailBinding
import com.example.pizzarestaurant.utils.Helper.capitalizeFirstLetter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class OrderDetailActivity:AppCompatActivity() {

    companion object{
        const val orderedFoodExtra ="extra_ordered_food"
    }

    private lateinit var orderMessage : String
    private val viewModel : OrderViewModel by viewModels()
    private lateinit var binding : ActivityOrderDetailBinding
    private lateinit var teksPiewSnackbar : TextView
    private lateinit var username : String
    private lateinit var storeLocation : String
    private lateinit var orderedFood : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        lifecycleScope.launch {
            viewModel.getUser.collect {
                username = it?.username.toString().capitalizeFirstLetter()
                storeLocation = it?.location.toString()
                binding.location.text = storeLocation
                binding.asep.text = username
            }
        }
        orderedFood = intent.getStringExtra(orderedFoodExtra).toString()
        binding.orderedFood.text = orderedFood

        binding.doneButton.setOnClickListener { p0 ->
            orderMessage = when {
                binding.rbOptionA.isChecked -> {
                    "Terima kasih $username, sudah memesan " +
                            "di toko kami, pesanan $orderedFood " +
                            "anda silahkan diambil di store $storeLocation Pizza"
                }
                binding.rbOptionB.isChecked -> {
                    "Terima kasih $username, sudah memesan " +
                            "di toko kami, pesanan $orderedFood " +
                            "anda akan dikirim menggunakan Fast Delivery"
                }
                else -> {
                    "Pilih salah satu pengiriman"
                }
            }

            val snackbar = p0?.let { Snackbar.make(it,"", Snackbar.LENGTH_LONG) }
            val customSnackView: View =
                layoutInflater.inflate(R.layout.custom_snackbar, null)
            snackbar?.view?.setBackgroundColor(Color.TRANSPARENT)
            snackbar?.duration = 5000
            val snackbarLayout = snackbar?.view as Snackbar.SnackbarLayout
            snackbarLayout.setPadding(0, 0, 0, 250)
            snackbarLayout.addView(customSnackView, 0)
            teksPiewSnackbar = customSnackView.findViewById(R.id.snackbarTextView)
            teksPiewSnackbar.text = orderMessage
            snackbar.show()
             }
        }
    }

