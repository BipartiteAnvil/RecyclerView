package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var titlesList = mutableListOf<String>()
    private var detailsList = mutableListOf<String>()
    private var imageList = mutableListOf<Int>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postToList()
        binding.rvRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.rvRecyclerView.adapter = RecyclerAdapter(titlesList, detailsList, imageList)

    }

    private fun addToList(title: String, detail: String, image: Int){
        titlesList.add(title)
        detailsList.add(detail)
        imageList.add(image)
    }

    private fun postToList(){
        for (i in 1..100){      // creating 100 items
            addToList("Title $i", "Description $i", R.mipmap.ic_launcher_round)
        }
    }


}