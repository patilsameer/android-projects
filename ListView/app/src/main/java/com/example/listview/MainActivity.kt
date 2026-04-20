package com.example.listview

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener{
    lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listView=findViewById(R.id.listView)

        var arrayAdapter= ArrayAdapter.createFromResource(this,R.array.numbers,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)


        listView.adapter=arrayAdapter
        listView.onItemClickListener=this

    }

    override fun onItemClick(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        var data=parent?.getItemAtPosition(position).toString()
        Toast.makeText(applicationContext,data,Toast.LENGTH_LONG).show()
    }
}