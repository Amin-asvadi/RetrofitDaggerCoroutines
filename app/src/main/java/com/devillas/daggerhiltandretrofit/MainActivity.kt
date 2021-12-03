package com.devillas.daggerhiltandretrofit

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.devillas.daggerhiltandretrofit.adapter.ImageAdapter
import com.devillas.daggerhiltandretrofit.databinding.ActivityMainBinding
import com.devillas.daggerhiltandretrofit.viewmodel.ImageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var imageAdapter: ImageAdapter
    private val viewModel: ImageViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
    }


    private fun setUpRecyclerView() {
        imageAdapter = ImageAdapter()
        binding.recyclerView.apply {
            adapter = imageAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }

        viewModel.responseImage.observe(this, { response ->
            if (response != null) {
                imageAdapter.submitList(response)
            }
        })
    }
}