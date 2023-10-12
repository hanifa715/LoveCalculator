package com.example.lovecalculator.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator.App
import com.example.lovecalculator.databinding.ItemHistoryBinding
import com.example.lovecalculator.model.LoveModel


class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private val list = arrayListOf<LoveModel>()

    fun addHistory(history: List<LoveModel>) {
        list.clear()
        list.addAll(history)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoryAdapter.HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryAdapter.HistoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        ViewHolder(binding.root) {
        fun bind(item: LoveModel) {
            with(binding) {
                tvHistoryFirstName.text = item.firstName
                tvHistorySecondName.text = item.secondName
                tvHistoryPercent.text = item.percentage
            }
        }
    }
}