package com.example.pizzarestaurant.ui.home_screen

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.TypefaceSpan
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.pizzarestaurant.R
import com.example.pizzarestaurant.databinding.ActivityHomeBinding
import com.example.pizzarestaurant.domain.model.User
import com.example.pizzarestaurant.ui.profile_screen.ProfileActivity
import com.example.pizzarestaurant.utils.CustomTypefaceSpan
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity: AppCompatActivity(), AdapterView.OnItemSelectedListener {



    private val viewModel : HomeViewModel by viewModels()
    private lateinit var binding: ActivityHomeBinding
    private lateinit var username : String
    private lateinit var location : String
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityHomeBinding.inflate(layoutInflater)
            setContentView(binding.root)
            supportActionBar?.hide()

            val spinner: Spinner = binding.placesSpinner
// Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter.createFromResource(
                this,
                R.array.planets_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                spinner.adapter = adapter
            }
            spinner.onItemSelectedListener = this

            val typeface = ResourcesCompat.getFont(this, R.font.roboto_bold)
            val hintText = "Please fill your name"
            val typefaceSpan: TypefaceSpan = CustomTypefaceSpan(typeface)
            val spannableString = SpannableString(hintText)

            spannableString.setSpan(
                typefaceSpan,
                0,
                spannableString.length,
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE
            )
            val textHintView = binding.inputYourName

            textHintView.hint = spannableString

    }


    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//         An item was selected. You can retrieve the selected item using
        val teksPiewSpinner = binding.spinnerTeksview
        val teksSpinner = p0?.getItemAtPosition(p2)
        teksPiewSpinner.text=teksSpinner.toString()
        location = teksSpinner.toString()
        binding.submitButton.setOnClickListener {

        username = binding.inputYourName.text.toString()
            if (username.isEmpty()){
                binding.inputYourName.error = "Name cannot be empty"
            }
            else{
                val intent = Intent(this@HomeActivity, ProfileActivity::class.java)
                startActivity(intent)
                viewModel.setUser(User(username,location))
            }
        }

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        // Another interface callback
        TODO()
    }

}