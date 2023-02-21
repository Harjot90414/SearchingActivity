package com.harjot.searchingactivity

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterClass(var array: ArrayList<UserModel>, var recyclerInterface: RecyclerInterface):
    RecyclerView.Adapter<RecyclerAdapterClass.ViewHolder>(){
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var lv= view.findViewById<LinearLayout>(R.id.lv)
        var tvAddress=view.findViewById<TextView>(R.id.tvAddress)
        var tvPhoneNo=view.findViewById<TextView>(R.id.tvPhonNo)
        var tvName= view.findViewById<TextView>(R.id.tvName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.setText(array[position].name)
        holder.tvAddress.setText(array[position].address)
        holder.tvPhoneNo.setText(array[position].phoneNo)
        holder.lv.setOnClickListener {
            recyclerInterface.click(position)
        }
    }
}