package com.example.myapplicationkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplicationkotlin.databinding.ActivityMainBinding
import com.example.myapplicationkotlin.databinding.ItemCakesBinding

class CakesAdapter(val cakesList: List<Cakes>, val listener: (position: Int) -> Unit) :
    RecyclerView.Adapter<CakesAdapter.CakesViewHolder>() {

    inner class CakesViewHolder(val binding: ItemCakesBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(cakes: Cakes){
            binding.apply {
                tvName.text = cakes.name
                tvDescription.text = cakes.desc
                tvPrise.text = cakes.prise
                Glide.with(itemView).load(cakes.image).into(ivCake)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakesViewHolder {
        val binding = CakesViewHolder(ItemCakesBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return  binding
    }

    override fun getItemCount(): Int {
        return cakesList.size
    }

    override fun onBindViewHolder(holder: CakesViewHolder, position: Int) {
        holder.bind(cakesList[position])
        holder.itemView.setOnClickListener{
            listener(position)
        }
    }
}