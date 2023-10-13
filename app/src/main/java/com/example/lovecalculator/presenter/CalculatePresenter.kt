package com.example.lovecalculator.presenter

import android.content.SharedPreferences
import android.util.Log
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.model.Pref
import com.example.lovecalculator.model.RetrofitService
import com.example.lovecalculator.ui.main.CalculateFragment
import com.example.lovecalculator.view.LoveView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CalculatePresenter @Inject constructor(private val sharedPreferences: SharedPreferences) {

    lateinit var loveView: LoveView

    @Inject
    lateinit var pref: Pref

    private var api = RetrofitService().api

    fun getLoveResult(firstName: String, secondName: String) {
        api.countCompatibility(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                response.body()?.let {
                    Log.e("ololo", "onResponse: ${response.body()}")
                    loveView.navigateToResultFragment(it)
                }
            }
            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                loveView.showError(t.message.toString())
            }
        })
    }

    fun setView(view: LoveView){
        this.loveView = view
    }

    fun showOnBoard(){
        if (!pref.isOnBoardingShowed())
            loveView.navigateToOnBoardingFragment()
    }
}