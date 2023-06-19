package com.example.postapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.postapi.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()

        val jsonPlaceholderApi = retrofitBuilder.create(JsonPlaceholderApi::class.java)
        val userPost = UserPost(1,1,"title","this is the body")
        val call = jsonPlaceholderApi.sendUserData(userPost)


        call.enqueue(object : Callback<UserPost>{
            override fun onFailure(call: Call<UserPost>, t: Throwable) {
                binding.tvHello.text = t.message.toString()
            }
            override fun onResponse(call: Call<UserPost>, response: Response<UserPost>) {
                binding.tvHello.text = response.code().toString()
            }


        })

    }
}