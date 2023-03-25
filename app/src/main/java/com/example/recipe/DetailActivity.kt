package com.example.recipe
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipe.databinding.ActivityDetailBinding
import com.example.recipe.models.Detail
import com.example.recipe.models.RecipesList
import com.example.recipe.models.Results
import com.example.recipe.models.Step
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    lateinit var adapter2: MyAdapter2
    lateinit var list: ArrayList<Step>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_detail)
        list=ArrayList()
        val retrofit= Retrofit.Builder().baseUrl("https://api.spoonacular.com/").addConverterFactory(
            GsonConverterFactory.create()).build()
        val getApi=retrofit.create(ApiInterface::class.java)
        getApi.getRecipeData2("d2ce1027b12f4e47950e2bf67dc0684f").enqueue(object : Callback<Detail?> {
            override fun onResponse(call: Call<Detail?>, response: Response<Detail?>) {
//                list=response.body()
//                adapter2=MyAdapter2(this@DetailActivity,list)
//                binding.recyclerView.adapter=adapter2
//                binding.recyclerView.layoutManager= LinearLayoutManager(this@DetailActivity)

            }

            override fun onFailure(call: Call<Detail?>, t: Throwable) {
                Log.d("finddata",t.toString())
            }
        })

    }














}