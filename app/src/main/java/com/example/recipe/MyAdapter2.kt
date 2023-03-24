package com.example.recipe

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.databinding.ListItem2Binding
import com.example.recipe.databinding.ListItemBinding
import com.example.recipe.models.Step

class MyAdapter2(val context: Context, val detailList:ArrayList<Step>):
RecyclerView.Adapter<MyAdapter2.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context)
        val binding: ListItem2Binding = DataBindingUtil.inflate(view,R.layout.list_item2,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=detailList[position]
        with(holder.binding){
            step1.text= currentItem.number.toString()
            method.text=currentItem.step
        }
    }
    override fun getItemCount(): Int {
        return detailList.size
    }
    class MyViewHolder(val binding: ListItem2Binding,):RecyclerView.ViewHolder(binding.root){

    }



}