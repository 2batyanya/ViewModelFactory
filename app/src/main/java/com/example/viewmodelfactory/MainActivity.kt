package com.example.viewmodelfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var  mViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel = ViewModelProvider(this, MainFactory(application, "Factory"))
            .get(MainViewModel::class.java)

    }

    override fun onStart() {
        super.onStart()
        var textView = findViewById<TextView>(R.id.textView)
        mViewModel.liveData.observe(this, Observer {
            textView.text = it
        })
    }
}