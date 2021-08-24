package com.asasuccessacademy.usictapp

import POJO
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var apiInterface:ApiInterface
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface::class.java)
        apiInterface.getpost().enqueue(object:Callback<List<POJO>>{
            override fun onResponse(call: Call<List<POJO>>, response: Response<List<POJO>>) {
                if(response.body()!!.isNotEmpty()){

                    var postList:List<POJO> = response.body()!!
                    var adapter:Adapter = Adapter(this@MainActivity,postList)
                    var linearLayout = LinearLayoutManager(this@MainActivity)
                    recyclerView.layoutManager = linearLayout
                    recyclerView.adapter = adapter
                }
                else{
                    Toast.makeText(this@MainActivity,"List is empty",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<POJO>>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.localizedMessage,Toast.LENGTH_LONG).show()
            }

        })
    }
}