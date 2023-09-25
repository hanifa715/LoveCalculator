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
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.R
import com.example.lovecalculator.RetrofitService
import com.example.lovecalculator.databinding.FragmentMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                RetrofitService().api.countCompatibility(
                    etFirstName.text.toString(),
                    etSecondName.text.toString()
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful){
                            Log.e("ololo", "onResponse: ${response.body()}", )
                            findNavController().navigate(
                                R.id.resultFragment, bundleOf(
                                    LOVE_MODEL_KEY to response.body()))
                        }
                        etFirstName.text?.clear()
                        etSecondName.text?.clear()
                        }
                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Toast.makeText(requireContext(), "onFailure: ${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
    companion object{
        const val LOVE_MODEL_KEY = "love.model.key"
    }
}