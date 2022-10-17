package com.aminivan.mvpheroku.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.aminivan.mvpheroku.R
import com.aminivan.mvpheroku.databinding.ActivityMainBinding
import com.aminivan.mvpheroku.model.getAllCarItem
import com.aminivan.mvpheroku.presenter.CarPresenter
import com.aminivan.mvpheroku.presenter.CarView

class MainActivity : AppCompatActivity(),CarView {
    lateinit var binding: ActivityMainBinding
    private lateinit var carPresenter: CarPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        carPresenter = CarPresenter(this)
        carPresenter.getCar()

    }

    override fun onSuccess(meg: String, car: List<getAllCarItem>) {
        binding.rvCar.layoutManager= LinearLayoutManager(this)
        binding.rvCar.adapter = CarAdapter(car)
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

}