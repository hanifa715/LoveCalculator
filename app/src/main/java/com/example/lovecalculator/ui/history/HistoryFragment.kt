package com.example.lovecalculator.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.App
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding

    private val adapter = HistoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        setData()
        initClickers()
    }

    private fun initClickers() {
        with(binding){
            ivHome.setOnClickListener {
                findNavController().navigate(R.id.mainFragment)
            }
            ivHistory.findNavController().navigate(R.id.historyFragment)
        }
    }

    private fun setData() {
        val data = App.appDatabase.loveDao().getAll()
        adapter.addHistory(data)

    }
}
