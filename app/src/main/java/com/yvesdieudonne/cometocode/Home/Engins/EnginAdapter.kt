package com.yvesdieudonne.cometocode.Home.Engins

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.textfield.TextInputEditText
import com.yvesdieudonne.cometocode.Home.Personne.EnginModel
import com.yvesdieudonne.cometocode.R

class EnginAdapter(var enginList:MutableList<EnginModel>, var mContext:AppCompatActivity): RecyclerView.Adapter<EnginAdapter.enginVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): enginVH {
        var itemView = LayoutInflater.from(mContext).inflate(R.layout.engin_rv, parent, false)
        return enginVH(itemView)
    }

    override fun getItemCount(): Int {
        return enginList.size
    }

    override fun onBindViewHolder(holder: enginVH, position: Int) {
        var person = enginList[position]
        holder.inflatePerson(person)
    }
    class enginVH(itemView:View): ViewHolder(itemView){

        @SuppressLint("SetTextI18n")
        fun inflatePerson(engin:EnginModel){
            var nom:TextView = itemView.findViewById(R.id.nameTv)
            var date:TextView = itemView.findViewById(R.id.dateTv)
            var prime:TextView = itemView.findViewById(R.id.primeTv)
            var desc:TextView = itemView.findViewById(R.id.descTv)
            var description:TextInputEditText = itemView.findViewById(R.id.descriptionTIET)
            var image: ImageView = itemView.findViewById(R.id.imageIV)

            nom.text = engin.Imatriculation
            date.text = engin.DateDisparition
            prime.text = "${engin.prime} FCFA"
            desc.text = engin.displayText
//            description.setText(engin.Description)
            image.setImageResource(engin.photoLists[0])
        }
    }
}

