package com.asasuccessacademy.usictapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private var retrofit: Retrofit? = null
        private var BASEURL: String = "https://jsonplaceholder.typicode.com/"
        fun getRetrofit(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}