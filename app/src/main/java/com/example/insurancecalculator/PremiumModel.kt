package com.example.insurancecalculator

import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class PremiumModel: ViewModel() {

    var premiumAmnt:Double=0.0

    override fun onCleared()
    {
        super.onCleared()
    }



}

