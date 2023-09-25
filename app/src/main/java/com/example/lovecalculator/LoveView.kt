package com.example.lovecalculator

import com.example.lovecalculator.remote.LoveModel

interface LoveView {
    fun showResult(loveModel: LoveModel)
    var loveModel: LoveModel?
}