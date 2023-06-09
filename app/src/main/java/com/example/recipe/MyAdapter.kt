package com.example.recipe

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.content.Context
import android.content.Intent
import com.example.recipe.databinding.ListItemBinding
import com.example.recipe.models.Results

class MyAdapter(val context: Context, val recipesList: ArrayList<Results>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context)
        val binding:ListItemBinding=DataBindingUtil.inflate(view,R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=recipesList[position]
        with(holder.binding){
            textview1.text=currentItem.title
            Glide.with(context)
                .load(currentItem.image)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(image1)
             item.setOnClickListener{
                val intent=Intent(context,DetailActivity::class.java)
                 context.startActivity(intent)
             }

        }
    }

    override fun getItemCount(): Int {
        return recipesList.size
    }
    class MyViewHolder(val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){

    }
}