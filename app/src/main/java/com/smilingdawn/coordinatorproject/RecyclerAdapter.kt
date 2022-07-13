package com.smilingdawn.coordinatorproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.smilingdawn.coordinatorproject.databinding.ItemSecondListBinding

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_second_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.title.text = "title $position"
    }

    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val binding: ItemSecondListBinding = DataBindingUtil.bind(view)!!
    }
}