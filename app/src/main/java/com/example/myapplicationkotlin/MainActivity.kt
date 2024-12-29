package com.example.myapplicationkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cakesButton.setOnClickListener(){
            supportFragmentManager.beginTransaction().add(R.id.fragment_container,RVCakesFragment()).commit()
        }
        binding.drinksButton.setOnClickListener(){
            supportFragmentManager.beginTransaction().add(R.id.fragment_container,RVDrinksFragment()).commit()
        }
    }
}