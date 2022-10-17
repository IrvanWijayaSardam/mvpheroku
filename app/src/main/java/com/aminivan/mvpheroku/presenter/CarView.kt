package com.aminivan.mvpheroku.presenter

import com.aminivan.mvpheroku.model.getAllCarItem

interface CarView {

    fun onSuccess(meg : String, news :List<getAllCarItem>)
    fun onError(msg : String)

}