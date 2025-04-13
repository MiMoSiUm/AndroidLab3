package com.example.androidlab3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CardAdapter(private val dataSet: DataSet) :
    RecyclerView.Adapter<CardAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val day: TextView
        val header: TextView
        val image: ImageView
        val description: TextView

        init {
            day = view.findViewById(R.id.day)
            header = view.findViewById(R.id.header)
            image = view.findViewById(R.id.image)
            description = view.findViewById(R.id.description)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.day.text = "День ${position + 1}"
        holder.header.text = dataSet.headers.getText(position)
        holder.image.setImageResource(dataSet.images.getResourceId(position, 0))
        holder.description.text = dataSet.descriptions.getText(position)
    }

    override fun getItemCount() = dataSet.headers.length()
}