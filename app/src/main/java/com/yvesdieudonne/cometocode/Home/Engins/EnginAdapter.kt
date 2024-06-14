package com.yvesdieudonne.cometocode.Home.Engins

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.yvesdieudonne.cometocode.Details.DetailsEngins.DetailsEngins
import com.yvesdieudonne.cometocode.R

class EnginAdapter(var enginList:MutableList<EnginModel>, var mContext:AppCompatActivity): RecyclerView.Adapter<EnginAdapter.enginVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): enginVH {
        var itemView = LayoutInflater.from(mContext).inflate(R.layout.engin_rv, parent, false)
        return enginVH(itemView, mContext)
    }

    override fun getItemCount(): Int {
        return enginList.size
    }

    override fun onBindViewHolder(holder: enginVH, position: Int) {
        var person = enginList[position]
        holder.inflatePerson(person)
    }
    class enginVH(itemView:View, var mContext: AppCompatActivity): ViewHolder(itemView){

        @SuppressLint("SetTextI18n")
        fun inflatePerson(engin: EnginModel){
            var nom:TextView = itemView.findViewById(R.id.nameTv)
            var date:TextView = itemView.findViewById(R.id.dateTv)
            var numberPhotoTV:TextView = itemView.findViewById(R.id.numberPhotoTV)
            var prime:TextView = itemView.findViewById(R.id.primeTv)
            var desc:TextView = itemView.findViewById(R.id.descTv)
            var description:TextInputEditText = itemView.findViewById(R.id.descriptionTIET)
            var image: ImageView = itemView.findViewById(R.id.imageIV)
            var detailMB: MaterialButton = itemView.findViewById(R.id.detailMB)

            nom.text = engin.Imatriculation
            date.text = engin.DateDisparition
//            prime.text = "${engin.prime} FCFA"
            desc.text = engin.displayText
            description.setText(engin.Description)
            numberPhotoTV.text = "+${engin.photoLists.size-1} photos"
            image.setImageResource(engin.photoLists[0])

            detailMB.setOnClickListener {
                Intent(mContext, DetailsEngins::class.java).also{
                    it.putExtra("imatriculation", engin.Imatriculation)
                    it.putExtra("date", engin.DateDisparition)
                    it.putExtra("lieu", engin.DernierLieu)
                    it.putExtra("prime", engin.prime)
                    it.putExtra("displayText", engin.displayText)
                    it.putExtra("description", engin.Description)
                    it.putExtra("Contact", engin.Contact)
                    it.putExtra("image", engin.photoLists.toIntArray())
                    mContext.startActivity(it)
                }
            }
        }
    }
}

