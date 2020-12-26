package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var firstVariable = 0.0
    private var secondVariable = 0.0
    private var operation = ""
    private var isDot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        ButtonOne.setOnClickListener(this)
        ButtonTwo.setOnClickListener(this)
        ButtonThree.setOnClickListener(this)
        ButtonFour.setOnClickListener(this)
        ButtonFive.setOnClickListener(this)
        ButtonSix.setOnClickListener(this)
        ButtonSeven.setOnClickListener(this)
        ButtonEight.setOnClickListener(this)
        ButtonNine.setOnClickListener(this)
        ButtonZero.setOnClickListener(this)
        ButtonDelete.setOnLongClickListener{
            ResultView.text = ""
            return@setOnLongClickListener true
        }
    }

    override fun onClick(v: View?) {
        val button :Button = v as Button
        ResultView.text = "${ResultView.text}${button.text}"
    }

    fun Dot(view:View){
        if(!isDot && ResultView.text.toString() != "") {
            ResultView.text = ResultView.text.toString() + "."
            isDot = true
        }
    }

    fun delete(view: View){
        val numbers:String = ResultView.text.toString()
        if(numbers.isNotEmpty()){
            ResultView.text = numbers.substring(0, numbers.length -1)
            if(numbers[numbers.length -1].toString() == "."){
                isDot = false
            }
            }
    }
    fun divide(vie:View){
        val value = ResultView.text.toString()
        operation = "/"
        firstVariable = value.toDouble()
        ResultView.text = ""
        isDot = false
    }
    fun subtract(view: View){
        val value = ResultView.text.toString()
        operation = "-"
        firstVariable = value.toDouble()
        ResultView.text = ""
        isDot = false
    }
    fun add(view:View){
        val value = ResultView.text.toString()
        operation = "+"
        firstVariable = value.toDouble()
        ResultView.text = ""
        isDot = false
    }
    fun multiply(view:View){
        val value = ResultView.text.toString()
        operation = "*"
        firstVariable = value.toDouble()
        ResultView.text = ""
        isDot = false
    }
    fun equal(view:View){
        isDot = false
        if (ResultView.text.toString() != "") {
            val value = ResultView.text.toString()
            secondVariable = value.toDouble()
            when (operation) {
                "/" -> if (secondVariable != 0.0) {
                    ResultView.text = (firstVariable / secondVariable).toString()
                } else {
                    Toast.makeText(this, "Can't divide by 0", Toast.LENGTH_SHORT).show()
                    ResultView.text = ""
                }

                "+" -> ResultView.text = (firstVariable + secondVariable).toString()
                "-" -> ResultView.text = (firstVariable - secondVariable).toString()
                "*" -> ResultView.text = (firstVariable * secondVariable).toString()

            }
        }else  {
            Toast.makeText(this, "Enter second number", Toast.LENGTH_SHORT).show()
        }
    }
}
