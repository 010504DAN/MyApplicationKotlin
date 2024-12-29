package com.example.myapplicationkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplicationkotlin.databinding.ItemDrinksBinding

class DrinksAdapter(
    private val drinksList: List<Drinks>,
    private val listener: (position: Int) -> Unit
) : RecyclerView.Adapter<DrinksAdapter.DrinksViewHolder>() {

    inner class DrinksViewHolder(val binding: ItemDrinksBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(drink: Drinks) {
            binding.apply {
                tvName.text = drink.name
                tvDescription.text = drink.desc
                tvPrise.text = drink.prise
                Glide.with(itemView).load(drink.image).into(ivDrink)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksViewHolder {
        val binding = ItemDrinksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DrinksViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return drinksList.size
    }

    override fun onBindViewHolder(holder: DrinksViewHolder, position: Int) {
        holder.bind(drinksList[position])
        holder.itemView.setOnClickListener {
            listener(position)
        }
    }
}
