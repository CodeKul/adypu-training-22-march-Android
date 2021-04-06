package com.example.myapplication.recyclerviewdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MenuAdapter(val context: Context,val list:ArrayList<String>): RecyclerView.Adapter<MenuAdapter.ViewHolder>() {



    class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        fun getMenuName():TextView{
            return itemView.findViewById(R.id.txtMenuName)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.cardmenu,parent,false)

        return MenuAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.getMenuName().text = list[position]
    }


}