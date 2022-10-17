package com.aminivan.mvpheroku.network

import com.aminivan.mvpheroku.model.getAllCarItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("admin/car")
    fun getAllCar() : Call<List<getAllCarItem>>

}