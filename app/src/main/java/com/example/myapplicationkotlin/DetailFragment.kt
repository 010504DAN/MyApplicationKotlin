package com.example.myapplicationkotlin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.myapplicationkotlin.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val phoneNumber: String = "+996123456789"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val cakes = DetailFragmentArgs.fromBundle(requireArguments())
            val drinks = DetailFragmentArgs.fromBundle(requireArguments())

            // Определяем, какой объект передан
            if (cakes != null) {
                setDataToUI(cakes.name, cakes.desc, cakes.prise, cakes.image)
            } else if (drinks != null) {
                setDataToUI(drinks.name, drinks.desc, drinks.prise, drinks.image)
            } else {
                throw IllegalArgumentException("No valid data found in arguments")
            }
        } else {
            throw IllegalArgumentException("Arguments are missing")
        }
    }

    private fun setDataToUI(name: String, desc: String, prise: String, image: String) {
        binding.tvName.text = name
        binding.tvDescription.text = desc
        binding.tvPrise.text = prise
        Glide.with(requireContext()).load(image).into(binding.ivCake)

        setupCallButton()
        setupOrderButton(name)
        setupBackButton()
    }

    private fun setupCallButton() {
        binding.callButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            startActivity(intent)
        }
    }

    private fun setupOrderButton(itemName: String) {
        binding.orderButton.setOnClickListener {
            val message = "Здравствуйте! Я хотел бы заказать $itemName."
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://wa.me/996123456789?text=${Uri.encode(message)}")
            }
            startActivity(intent)
        }
    }

    private fun setupBackButton(){
        binding.backButton.setOnClickListener(){
            findNavController().navigateUp()
        }
    }
}
