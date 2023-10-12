package com.example.lovecalculator.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentMainBinding
import com.example.lovecalculator.presenter.CalculatePresenter
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.view.LoveView

class CalculateFragment : Fragment(),LoveView {

    private lateinit var binding: FragmentMainBinding

    private val presenter = CalculatePresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setView(this)
        initClickers()
    }

    private fun initClickers() {
        binding.btnCalculate.setOnClickListener {
            presenter.getLoveResult(binding.etFirstName.text.toString(), binding.etSecondName.text.toString())
        }
        binding.btnHome.setOnClickListener {
            findNavController().navigate(R.id.mainFragment) }
        binding.btnHistory.setOnClickListener {
            Log.e("ololo", "main: click", )
            findNavController().navigate(R.id.historyFragment)
        }
    }


    override fun navigateToResultFragment(loveModel: LoveModel) {
        findNavController().navigate(R.id.resultFragment, bundleOf(LOVE_MODEL_KEY to loveModel))

        binding.etFirstName.text?.clear()
        binding.etSecondName.text?.clear()
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(),error,Toast.LENGTH_SHORT).show()
    }

    companion object{
        const val LOVE_MODEL_KEY = "love.model.key"
    }
}