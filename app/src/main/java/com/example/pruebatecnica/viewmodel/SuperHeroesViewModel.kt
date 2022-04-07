package com.example.pruebatecnica.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pruebatecnica.model.SuperHeroe
import com.example.pruebatecnica.service.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroesViewModel : ViewModel() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://superheroapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service : APIService = retrofit.create(APIService::class.java)
    val heroeSolo = ArrayList<SuperHeroe>()
    val heroesList = MutableLiveData<List<SuperHeroe>>()



    fun getHeroesList (){

        CoroutineScope(Dispatchers.IO).launch{

            for (i in 1..730){

                val call = service.getHeroe(i)

                call.enqueue(object : Callback<SuperHeroe>{

                    override fun onResponse(
                        call: Call<SuperHeroe>,
                        response: Response<SuperHeroe>
                    ) {

                        response.body()?.let {  heroe ->
                            heroeSolo.add(heroe)
                            heroesList.value = heroeSolo
                        }
                    }

                    override fun onFailure(call: Call<SuperHeroe>, t: Throwable) {
                        call.cancel()
                    }

                })
            }

        }
    }
}