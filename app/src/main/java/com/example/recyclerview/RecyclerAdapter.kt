package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter (private var titles: List<String>, private var details: List<String>, private var images: List<Int>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val viewholder = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(viewholder)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemPicture.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val itemTitle : TextView = itemView.findViewById(R.id.tv_Title)
        val itemDetail: TextView = itemView.findViewById(R.id.tv_description)
        val itemPicture : ImageView = itemView.findViewById(R.id.iv_image)

        init {
            itemView.setOnClickListener {
                val position : Int = adapterPosition
                Toast.makeText(itemView.context, "Clicked On ${position+1}", Toast.LENGTH_SHORT).show()
            }
        }

    }


}