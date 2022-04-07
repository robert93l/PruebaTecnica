package com.example.pruebatecnica.service

import com.example.pruebatecnica.model.SuperHeroe
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    @GET("4754465601251892/{id}")
    fun getHeroe(@Path("id") id: Int ) : Call<SuperHeroe>
}