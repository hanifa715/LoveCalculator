package com.example.lovecalculator.ui.result

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.App
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.R
import com.example.lovecalculator.ui.main.CalculateFragment.Companion.LOVE_MODEL_KEY
import com.example.lovecalculator.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loveModel = arguments?.getSerializable(LOVE_MODEL_KEY) as LoveModel
        App.appDatabase.loveDao().insert(loveModel)
        with(binding){
            tvFirstName.text = loveModel.firstName
            tvSecondName.text = loveModel.secondName
            tvPercent.text = loveModel.percentage + "%"
            tvResult.text = loveModel.result
            btnTry.setOnClickListener {
                findNavController().navigateUp()
            }

            btnHome.setOnClickListener {
                findNavController().navigateUp()
            }
            btnHistory.setOnClickListener {
                Log.e("ololo", "result: Click" )
                findNavController().navigate(R.id.historyFragment)
            }
        }
    }
}