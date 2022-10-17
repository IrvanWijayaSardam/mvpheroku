package com.aminivan.mvpheroku.presenter

import android.util.Log
import com.aminivan.mvpheroku.model.getAllCarItem
import com.aminivan.mvpheroku.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarPresenter(val cars : CarView) {

    fun getCar(){
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<getAllCarItem>> {
                override fun onResponse(
                    call: Call<List<getAllCarItem>>,
                    response: Response<List<getAllCarItem>>
                ) {
                    if (response.isSuccessful){
                        cars.onSuccess(response.message(), response.body()!!)
                        Log.d("cars", response.body().toString())
                    }else{
                        cars.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<getAllCarItem>>, t: Throwable) {
                    cars.onError(t.message!!)
                }

            })
    }

}