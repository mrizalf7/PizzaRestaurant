package com.example.pizzarestaurant.ui.menu_list_screen

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pizzarestaurant.R
import com.example.pizzarestaurant.domain.model.Pizza
import com.example.pizzarestaurant.ui.detail_pizza.PizzaDetail

class MenuListAdapter(private val listPizza: ArrayList<Pizza>): RecyclerView.Adapter<MenuListAdapter.ListViewHolder>(){


    class ListViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        var pizzaName: TextView = itemView.findViewById(R.id.pizzaNamez)
        var pizzaPicture: ImageView = itemView.findViewById(R.id.pizzaPicture)
        var pizzaDescription1 : TextView = itemView.findViewById(R.id.pizzaDesc1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_pizza, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (pizzaName,pizzaPhoto,pizzaDesc1,pizzaDesc2,pizzaPrice) = listPizza[position]
        Glide.with(holder.itemView.context)
            .load(pizzaPhoto)
            .apply(RequestOptions())
            .into(holder.pizzaPicture)
        val mContext = holder.itemView.context
        holder.pizzaName.text = pizzaName
        holder.pizzaDescription1.text = pizzaDesc1

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, PizzaDetail::class.java)
            moveDetail.putExtra(PizzaDetail.EXTRA_pizzaName,pizzaName)
            moveDetail.putExtra(PizzaDetail.EXTRA_pizzaPhoto,pizzaPhoto)
            moveDetail.putExtra(PizzaDetail.EXTRA_pizzaDesc1,pizzaDesc1)
            moveDetail.putExtra(PizzaDetail.EXTRA_pizzaDesc2,pizzaDesc2)
            moveDetail.putExtra(PizzaDetail.EXTRA_pizzaPrice,pizzaPrice)
            mContext.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int {
        return listPizza.size
    }

}