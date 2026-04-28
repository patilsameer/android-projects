package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class CountriesAdapter(
       var countryNameList: ArrayList<String>,
       var detailsList: ArrayList<String>,
       var imageList: ArrayList<Int>,
       var context: Context
    ) : Adapter<CountriesAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryViewHolder {
        val view: View= LayoutInflater.from(parent.context).inflate(R.layout.card_design,parent,false)

        return CountryViewHolder(view)
    }


    override fun onBindViewHolder(
        holder: CountryViewHolder,
        position: Int
    ) {
        holder.textViewCountryname.text=countryNameList.get(position)
        holder.textViewDetails.text=detailsList.get(position)
        holder.imageView.setImageResource(imageList.get(position))
    }

    override fun getItemCount(): Int {
        return countryNameList.size
    }

    class CountryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var textViewCountryname: TextView = itemView.findViewById(R.id.textViewcountryName)
        var textViewDetails: TextView=itemView.findViewById(R.id.textViewDetail)
        var imageView: ImageView=itemView.findViewById(R.id.imageView)
    }

}



