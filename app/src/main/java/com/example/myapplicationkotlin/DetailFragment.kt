package com.example.myapplicationkotlin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.myapplicationkotlin.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private var phoneNumber: String = "+996123456789"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val args = requireArguments().getParcelable<Cakes>("cakes")
                ?: throw IllegalArgumentException("Cakes data missing")
            binding.tvName.text = args.name
            binding.tvDescription.text = args.desc
            binding.tvPrise.text = args.prise
            Glide.with(requireContext()).load(args.image).into(binding.ivCake)

            binding.callButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:$phoneNumber")
                startActivity(intent)
            }

            binding.orderButton.setOnClickListener {
                val message = "Здравствуйте! Я хотел бы заказать ${args.name}."
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://wa.me/996123456789?text=${Uri.encode(message)}")
                startActivity(intent)
            }
        }
    }
}
