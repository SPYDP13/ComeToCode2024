package com.yvesdieudonne.cometocode.Home.Personne

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
import com.yvesdieudonne.cometocode.R

class PersonAdapter(var personList:MutableList<PersonneModel>, var mContext:AppCompatActivity): RecyclerView.Adapter<personVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): personVH {
        var itemView = LayoutInflater.from(mContext).inflate(R.layout.personne_rv, parent, false)
        return personVH(itemView)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: personVH, position: Int) {
        var person = personList[position]
        holder.inflatePerson(person)
    }

}

class personVH(itemView:View): ViewHolder(itemView){

    @SuppressLint("SetTextI18n")
    fun inflatePerson(person:PersonneModel){
        var nom:TextView = itemView.findViewById(R.id.nameTv)
        var date:TextView = itemView.findViewById(R.id.dateTv)
        var prime:TextView = itemView.findViewById(R.id.primeTv)
        var desc:TextView = itemView.findViewById(R.id.descTv)
        var description:TextInputEditText = itemView.findViewById(R.id.descriptionTIET)
        var image: ImageView = itemView.findViewById(R.id.imageIV)

        nom.text = person.nomPrenom
        date.text = person.DateDisparition
        prime.text = "${person.prime} FCFA"
        desc.text = person.displayText
//        description.setText(person.Description)
        image.setImageResource(person.photoLists[0])
    }
}