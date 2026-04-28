package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    var countryNameList= ArrayList<String>()
    var detailsList= ArrayList<String>()
    var imageList= ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager= LinearLayoutManager(this@MainActivity)

        countryNameList.add("India")
        countryNameList.add("USA")
        countryNameList.add("UK")

        detailsList.add("This is Bharat")
        detailsList.add("This is United States of America")
        detailsList.add("This is United Kingdom")

        imageList.add(R.drawable.india)
        imageList.add(R.drawable.usa)
        imageList.add(R.drawable.ukflag)

        var adapter= CountriesAdapter(countryNameList,detailsList,imageList,this@MainActivity)

        recyclerView.adapter=adapter
    }

}