package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Story

class StoryAdapter(val list:ArrayList<Story>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val OTHERITEM=0
    val STORYITEM=1
    override fun getItemViewType(position: Int): Int {
        if(position==0){
            return OTHERITEM
        }
        else{
            return STORYITEM
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType==OTHERITEM) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_mystoriy, parent, false)
            return MyStoryViewHolder(view)
        }
        else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_recomended, parent, false)
            return StoryViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is StoryViewHolder){
            val storis = list[position]
            holder.apply {
                story.setImageResource(storis.storisUrl)
                profile.setImageResource(storis.profileUrl)
                name.text=storis.fullName
            }
        }
        else if(holder is MyStoryViewHolder){
            holder.apply {
                profile.setImageResource(R.drawable.img_1)
                fullName.text="Add to Story"
            }
        }
    }

    override fun getItemCount()=list.size
    class StoryViewHolder(view: View):RecyclerView.ViewHolder(view){
        val story=view.findViewById<ImageView>(R.id.iv_storis)
        val profile=view.findViewById<ImageView>(R.id.iv_profile)
        val name=view.findViewById<TextView>(R.id.tv_name)
    }
    class MyStoryViewHolder(view: View):RecyclerView.ViewHolder(view){
        val profile=view.findViewById<ImageView>(R.id.iv_mystoris)
        val fullName=view.findViewById<TextView>(R.id.tv_fullname)
    }
}