package com.example.postapi

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface JsonPlaceholderApi {

    @POST("posts")
    fun sendUserData(
      @Body userPost: UserPost
    ): Call<UserPost>
}