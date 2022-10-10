package com.example.drawer.calculator

import android.content.ContentValues.TAG
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.MenuItem
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import com.example.drawer.R
//import com.example.drawer.calculator.R.id.tips

class tipcalculatormain : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var seekBar: SeekBar
    private lateinit var percentage: TextView
    private lateinit var tips: TextView
    private lateinit var total: TextView
    private lateinit var tipdesc: TextView
    private lateinit var tipdesclabel: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        name = findViewById(R.id.name)
        seekBar = findViewById(R.id.seekBar)
        percentage = findViewById(R.id.percentage)
        tips = findViewById(R.id.tips)
        total = findViewById(R.id.total)
        tipdesc = findViewById(R.id.tipdesc)
        tipdesclabel = findViewById(R.id.tipdesclabel)

        addEditTextListener()
        addSeekBarListener()

        supportActionBar?.title = "Tip Calculator"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun addEditTextListener(){
        name.setText(" ")

        name.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                Log.d("MainActivity", s?.toString() ?: "")

                computeTip()
            }
        })
    }

    private fun addSeekBarListener(){
       seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
           override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
               Log.d("Main Activity","$progress")

               percentage.text = "$progress%"
               computeTip()
           }

           override fun onStartTrackingTouch(seekBar: SeekBar?) {
           }

           override fun onStopTrackingTouch(seekBar: SeekBar?) {
           }
       })
    }

    private fun computeTip(){
        val name = name.text.toString().toDoubleOrNull() ?: 0.0
        val percentage = seekBar.progress

        val tip = name * (percentage/100.0)
        val totalamt = name + tip
        var desc = " "

        Log.d("Main Activity", "$tip")
        tips.text = "%.2f".format(tip)
        total.text = "%.2f".format(totalamt)

        desc = when (percentage!!.toInt()){
            in 0..9 -> "Poor"
            in 10..15 -> "Good"
            else -> "Generous"
        }

        when (desc){
            in "Poor" -> tipdesclabel.setTextColor(Color.parseColor("#FF6B4C")).toString()
            in "Good" -> tipdesclabel.setTextColor(Color.parseColor("#F4F540")).toString()
            else -> tipdesclabel.setTextColor(Color.parseColor("#3DEF65")).toString()
        }

        tipdesclabel.text = desc
        Log.d("MainActivity", "$desc")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}