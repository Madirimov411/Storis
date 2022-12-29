package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.StoryAdapter
import com.example.myapplication.model.Story

class MainActivity : AppCompatActivity() {
    lateinit var list:ArrayList<Story>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        list=loadList()
        val rvStory=findViewById<RecyclerView>(R.id.rv_story)
        rvStory.adapter=StoryAdapter(list)
        val layoutManager=GridLayoutManager(this,2)
        rvStory.layoutManager=layoutManager
    }

    private fun loadList(): ArrayList<Story> {
        var mylist=ArrayList<Story>()
        mylist.add(Story(R.drawable.img_1,R.drawable.img,"Mansurbek"))
        mylist.add(Story(R.drawable.img_1,R.drawable.img,"Mansurbek"))
        mylist.add(Story(R.drawable.img_1,R.drawable.img,"Mansurbek"))
        mylist.add(Story(R.drawable.img_1,R.drawable.img,"Mansurbek"))
        mylist.add(Story(R.drawable.img_1,R.drawable.img,"Mansurbek"))
        mylist.add(Story(R.drawable.img_1,R.drawable.img,"Mansurbek"))
        mylist.add(Story(R.drawable.img_1,R.drawable.img,"Mansurbek"))
        return mylist
    }
}