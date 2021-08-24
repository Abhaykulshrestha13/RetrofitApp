package com.asasuccessacademy.usictapp

import POJO
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun getpost(): Call<List<POJO>>
}