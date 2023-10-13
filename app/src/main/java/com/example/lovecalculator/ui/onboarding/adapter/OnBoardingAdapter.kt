package com.example.lovecalculator.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemOnBoardingBinding
import com.example.lovecalculator.model.OnBoarding


class OnBoardingAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val list = arrayListOf(
        OnBoarding(
            R.drawable.onboarding1,
            " Welcome to Love Calculator",
            "We'll help you explore and understand the strength of your love with your partner. Let's get started!"
        ),
        OnBoarding(
            R.drawable.onboarding2,
            "Enter Your and Your Partner's Names",
            "Just fill in your name and your partner's name, and we'll reveal exciting results for you."
        ),
        OnBoarding(
            R.drawable.onboarding3,
            "Your Love Score Is...",
            " Your love score is XX%! This number represents the depth of your love with your partner. Keep exploring the app to discover more about love."
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) = with(binding) {
            tvTitle.text = onBoarding.title
            tvDesc.text = onBoarding.description
            onBoarding.image?.let { ivBoard.setImageResource(it) }
            btnStart.isVisible = adapterPosition == list.lastIndex
            tvSkip.isVisible = adapterPosition != list.lastIndex
            btnStart.setOnClickListener {
                onClick()
            }
            tvSkip.setOnClickListener {
                onClick()
            }

        }

    }
}