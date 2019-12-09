package com.example.insurancecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    lateinit var myData:PremiumModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myData = ViewModelProviders.of(this).get(PremiumModel::class.java)
        display() //call before clicking calculate because when rotating will call this function again
        findViewById<Button>(R.id.calculate).setOnClickListener{
            myData.premiumAmnt = calculatePremium()
            display()

        }
        findViewById<Button>(R.id.reset).setOnClickListener {
            resetAll()
            myData.premiumAmnt=0.0 //clear everything including the data
        }
    }

    private fun calculatePremium ():Double{
        return when (spinner.selectedItemPosition) {
            0->60.00
            1->70.00+
                    (if(gendergroup.malerad.isChecked) 60.00 else 0.0)+
                    (if(smokercheck.isChecked)100.00 else 0.0)
            2-> 90.00+
                    (if(gendergroup.malerad.isChecked) 100.00 else 0.0)+
                    (if(smokercheck.isChecked)150.00 else 0.0)
            3-> 120.00
            4-> 150.00
            else->150.00
        }
    }
    private fun display(){
        if(myData.premiumAmnt!=0.0)
        totalpremium.text=myData.premiumAmnt.toString()
    }
    private fun resetAll(){

        spinner.setSelection(0)
        smokercheck.isChecked=false
        gendergroup.clearCheck()
        totalpremium.text=""



    }
}
