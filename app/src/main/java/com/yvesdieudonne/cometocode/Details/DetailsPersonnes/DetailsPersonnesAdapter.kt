package com.yvesdieudonne.cometocode.Details.DetailsPersonnes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.yvesdieudonne.cometocode.R

class DetailsPersonnesAdapter(var photoList:MutableList<Int>,var mContext:AppCompatActivity):RecyclerView.Adapter<DetailsPersonnesAdapter.viewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsPersonnesAdapter.viewHolder {
        var itemView = LayoutInflater.from(mContext).inflate(R.layout.photo_rv, parent, false)
        return viewHolder(itemView, mContext)
    }

    override fun onBindViewHolder(holder: DetailsPersonnesAdapter.viewHolder, position: Int) {
        var photo = photoList[position]
        holder.addItem(photo)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }


    class viewHolder(itemView:View, var mContext:AppCompatActivity):ViewHolder(itemView){
        fun addItem(photo: Int) {
            var DetailPhotoIV = itemView.findViewById<ImageView>(R.id.DetailPhotoIV)
            DetailPhotoIV.setImageResource(photo)
        }

    }
}