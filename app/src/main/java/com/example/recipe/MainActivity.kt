package com.example.recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipe.databinding.ActivityMainBinding
import com.example.recipe.models.RecipesList
import com.example.recipe.models.Results
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var adapter: MyAdapter
    lateinit var list: ArrayList<Results>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        list=ArrayList()
        val retrofit= Retrofit.Builder().baseUrl("https://api.spoonacular.com/").addConverterFactory(
            GsonConverterFactory.create()).build()
        val getApi=retrofit.create(ApiInterface::class.java)

          getApi.getRecipeData(100,"d2ce1027b12f4e47950e2bf67dc0684f").enqueue(object : Callback<RecipesList?> {
              override fun onResponse(call: Call<RecipesList?>, response: Response<RecipesList?>) {
                  list= (response.body()?.results as ArrayList<Results>?)!!

                  adapter=MyAdapter(this@MainActivity,list)
                  binding.recyclerView.adapter=adapter
                  binding.recyclerView.layoutManager=LinearLayoutManager(this@MainActivity
                  )

              }

              override fun onFailure(call: Call<RecipesList?>, t: Throwable) {
                  Toast.makeText(this@MainActivity, "SomeThing Went Wrong", Toast.LENGTH_SHORT).show()

              }
          })
    }

























}