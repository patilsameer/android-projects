package com.example.spineer

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var textView: TextView
    lateinit var spinner: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textView=findViewById(R.id.textView)
        spinner=findViewById(R.id.spinner)

        var arrayAdapter= ArrayAdapter.createFromResource(this,R.array.colors, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

        spinner.adapter=arrayAdapter
        spinner.onItemSelectedListener=this
    }

    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        if(position==0){
            textView.setTextColor(Color.RED)
        } else if(position==1){
            textView.setTextColor(Color.GREEN)
        } else if(position==2){
            textView.setTextColor(Color.BLUE)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}