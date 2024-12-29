package com.example.myapplicationkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplicationkotlin.databinding.FragmentDetailBinding
import com.example.myapplicationkotlin.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cakesButton.setOnClickListener(){
            findNavController().navigate(MainFragmentDirections.actionMainFragment2ToRVCakesFragment())
        }
        binding.drinksButton.setOnClickListener(){
            findNavController().navigate(MainFragmentDirections.actionMainFragment2ToRVDrinksFragment())
        }
    }
}