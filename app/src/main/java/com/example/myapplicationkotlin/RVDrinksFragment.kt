package com.example.myapplicationkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplicationkotlin.databinding.FragmentRVCakesBinding
import com.example.myapplicationkotlin.databinding.FragmentRVDrinksBinding

class RVDrinksFragment : Fragment() {
    private lateinit var binding: FragmentRVDrinksBinding

    private lateinit var drinksAdapter: DrinksAdapter
    private val drinksList = arrayListOf<Drinks>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRVDrinksBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoad()
        initRV()
    }

    private fun initRV() {
        drinksAdapter = DrinksAdapter(drinksList){
            val bundle = Bundle()
            bundle.putParcelable("drinks", drinksList[it])
            val  detailFragment = DetailFragment()
            detailFragment.arguments = bundle
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container, detailFragment).addToBackStack(null).commit()
        }
        binding.rvDrink.adapter = drinksAdapter
    }

    private fun onLoad() {
        drinksList.add(Drinks(imageDrinks1,"Молочный Шейк",
            "Классический молочный шейк с ванильным и шоколадным вкусом.",
            " 200 сом"))
        drinksList.add(Drinks(imageDrinks2,"Коктейль Манго",
            "Тропический коктейль с манго и маракуйей. Легкий, освежающий вкус идеально подходит для летних дней.",
            "200 сом"))
    }
}
const val imageDrinks1 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWbNJNGkcixwIKyNJ-neYJU2NCdDmOHp1DkQ&s"
const val imageDrinks2 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpy1dbnSyYrr_gHOX-Kk7VX2U573N-qQZpww&s"
