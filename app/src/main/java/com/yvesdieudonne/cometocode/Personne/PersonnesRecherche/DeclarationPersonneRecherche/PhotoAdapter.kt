package com.yvesdieudonne.cometocode.Personne.PersonnesRecherche.DeclarationPersonneRecherche

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.yvesdieudonne.cometocode.R

class PhotoAdapter(var photoList: MutableList<Bitmap>, var mContext:AppCompatActivity):RecyclerView.Adapter<PhotoAdapter.PhotoVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapter.PhotoVH {
        var itemView = LayoutInflater.from(mContext).inflate(R.layout.image_rv, parent, false)
        return PhotoVH(itemView, photoList, this)
    }

    override fun onBindViewHolder(holder: PhotoAdapter.PhotoVH, position: Int) {
        var bitmap = photoList[position]
        holder.addPhoto(bitmap, position)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    class PhotoVH(itemView:View, var photoList:MutableList<Bitmap>, var adapter:PhotoAdapter):ViewHolder(itemView) {
        fun addPhoto(bitmap: Bitmap, position: Int){
            var imageIV:ImageView = itemView.findViewById(R.id.imageIV)
            var deleteImgIV:ImageView = itemView.findViewById(R.id.deleteImgIV)
            imageIV.setImageBitmap(bitmap)

            deleteImgIV.setOnClickListener {
                photoList.removeAt(position)
                adapter.notifyItemRemoved(position)
            }
        }
    }
}