package com.example.myapplicationkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplicationkotlin.databinding.FragmentRVCakesBinding

class RVCakesFragment : Fragment() {
    private lateinit var binding: FragmentRVCakesBinding

    private lateinit var cakesAdapter: CakesAdapter
    private val cakesList = arrayListOf<Cakes>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRVCakesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoad()
        initRV()
    }

    private fun initRV() {
        cakesAdapter = CakesAdapter(cakesList){
            findNavController().navigate(
                RVCakesFragmentDirections.actionRVCakesFragmentToDetailFragment(
                image = cakesList[it].image,
                name = cakesList[it].name,
                desc = cakesList[it].desc,
                prise = cakesList[it].prise
            ))
            /*findNavController().navigate(R.id.action_RVCakesFragment_to_detailFragment, bundle)*/
            /*requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container, detailFragment).addToBackStack(null).commit()*/
        }
        binding.rvCakes.adapter = cakesAdapter
    }

    private fun onLoad() {
        cakesList.add(Cakes(image1,"Йогуртовый",
            "Йогуртовый торт с манго и маракуей - это легкий и освежающий десерт, который сочетает в себе сладкие ноты тропических фруктов и нежный вкус йогурта. Этот торт идеально подходит для тех, кто предпочитает легкие и здоровые десерты.",
            " 990 сом"))
        cakesList.add(Cakes(image2,"Три Шоколада",
            "Торт состоит из шоколадно-орехового бисквита и трех поочередно залитых муссов на основе темного, молочного и белого шоколада. Бока торта обернуты в тонкий бисквит «Джаконд» изготовленный на основе миндальной муки, а в качестве декора нанесен рисунок ганашом из темного шоколада.",
            "1250 сом"))
        cakesList.add(Cakes(image3, "Три Шоколада",
            "Шоколадный фондан — популярное французское десертное блюдо, кекс из шоколадного бисквитного теста. Его особенностью является твёрдая хрустящая оболочка и жидкая сердцевина.",
            "550 сом"))
    }
}
const val image1 = "https://site.kulikov.com/upload/iblock/cfd/st5szu0lxnlge1pdc15hqson26vpoynw/%D0%A1%D0%B0%D0%B9%D1%82_%D0%B9%D0%BE%D0%B3%D1%83%D1%80%D1%82%D0%BE%D0%B2%D1%8B%D0%B9_%D0%BC%D0%B0%D0%BD%D0%B3%D0%BE_%D0%BC%D0%B0%D1%80%D0%B0%D0%BA%D1%83%D0%B9%D1%8F-2.png"
const val image2 = "https://site.kulikov.com/upload/iblock/5ba/6ogw2atnhjq5mtheajzs7h6rfha46k4j/%D1%82%D1%80%D0%B8%20%D1%88%D0%BE%D0%BA%D0%BE%20%D0%BD%D0%B3.png"
const val image3 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6d13Fj_5J7IUzHLusp4Uk_bWwzpO-A2xi0w&s"