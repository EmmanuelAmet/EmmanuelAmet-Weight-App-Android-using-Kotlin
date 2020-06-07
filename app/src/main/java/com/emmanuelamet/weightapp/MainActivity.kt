package com.emmanuelamet.weightapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.CheckBox
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnClickListener{

    val massGravity: Float = 0.3F
    val jupiterGravity: Float = 0.91F
    val earthGravity : Float = 9.8F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chkEarth.setOnClickListener(this)
        chkMass.setOnClickListener(this)
        chkJupiter.setOnClickListener(this)
        var weight = txtWeight.text
        btnShowWeight.setOnClickListener {
            //var result = calculateWeight(weight.toString().toDouble())
/*
            if(weight.isEmpty()){
                lblWeight.text = "Enter your weight"
            }else{
                lblWeight.text = "Great " + result
            }

 */
        }
    }
    fun calculateWeight(input:Double, checkBox: CheckBox){
        var result: Double?
        when(checkBox.id){
            R.id.chkMass -> {
                result = input * massGravity
                lblWeight.text = "Great " + result + " on Mars"
            }
            R.id.chkEarth -> {
                result = input * earthGravity
                lblWeight.text = "Great " + result + " on Earth"
            }
            R.id.chkJupiter -> {
                result = input * jupiterGravity
                lblWeight.text = "Great " + result + " on Jupiter"
            }
            else -> {
                result = input * earthGravity
                lblWeight.text = result.toString()
            }
        }

        fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)

    }



    override fun onClick(v: View?) {
        v as CheckBox
        var weight = txtWeight.text
        var isCheckBox : Boolean = v.isChecked
        when(v.id) {
            R.id.chkEarth -> if (isCheckBox && !TextUtils.isEmpty(txtWeight.text.toString())){
                calculateWeight(weight.toString().toDouble(), v)
            }else{
                Toast.makeText(this, "You must enter your mass", Toast.LENGTH_LONG).show()
            }
            R.id.chkMass -> if(isCheckBox && !TextUtils.isEmpty(txtWeight.text.toString())){
                calculateWeight(weight.toString().toDouble(), v)
            }else{
                Toast.makeText(this, "You must enter your mass", Toast.LENGTH_LONG).show()
            }
            R.id.chkJupiter -> if(isCheckBox && !TextUtils.isEmpty(txtWeight.text.toString())){
                calculateWeight(weight.toString().toDouble(), v)
            }else{
                Toast.makeText(this, "You must enter your mass", Toast.LENGTH_LONG).show()
            }
        }
    }
}
