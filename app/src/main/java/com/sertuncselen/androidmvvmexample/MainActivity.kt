package com.sertuncselen.androidmvvmexample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.sertuncselen.androidmvvmexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainActivityViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel.counter.observe(this, Observer { counterValue ->
            binding.txtResult.text = counterValue.toString()
        })

        binding.btnNext.setOnClickListener {
            viewModel.upCounter()
        }
    }
}
