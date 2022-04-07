package com.example.pruebatecnica.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pruebatecnica.model.SuperHeroe
import com.example.pruebatecnica.service.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeroeViewModel() : ViewModel() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://superheroapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: APIService = retrofit.create(APIService::class.java)

    val heroe = MutableLiveData<SuperHeroe>()

    fun getHeroe(id : Int){

        val call = service.getHeroe(id)
        call.enqueue(object : Callback<SuperHeroe> {

            override fun onResponse(
                call: Call<SuperHeroe>,
                response: Response<SuperHeroe>
            ) {
                response.body()?.let { it ->
                    heroe.postValue(it)

                }
            }

            override fun onFailure(call: Call<SuperHeroe>, t: Throwable) {
                call.cancel()
            }

        })
    }
}