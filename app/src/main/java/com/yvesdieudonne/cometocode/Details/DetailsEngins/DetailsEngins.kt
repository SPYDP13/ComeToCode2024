package com.yvesdieudonne.cometocode.Details.DetailsEngins

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.google.android.material.imageview.ShapeableImageView
import com.yvesdieudonne.cometocode.Home.Engins.EnginModel
import com.yvesdieudonne.cometocode.MenuNavigation
import com.yvesdieudonne.cometocode.R

class DetailsEngins : AppCompatActivity() {
    lateinit var menuIV: ImageView
    lateinit var menuCL: ConstraintLayout
    lateinit var closeMenuIV: ImageView
    lateinit var detailPhotoRV: RecyclerView
    lateinit var DetailsNomTV: TextView
    lateinit var DetailSIV: ShapeableImageView
    lateinit var displayTextTV: TextView
    lateinit var DateTV: TextView
    lateinit var LieuTV: TextView
    lateinit var PrimeTV: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_engins)


        /*Recuperation des valeurs des intents */
        val imatriculation = intent.getStringExtra("imatriculation")
        val date = intent.getStringExtra("date")
        val lieu = intent.getStringExtra("lieu")
        val prime = intent.getLongExtra("prime", 0)
        val displayText = intent.getStringExtra("displayText")
        val description = intent.getStringExtra("description")
        val Contact = intent.getStringExtra("Contact")
        val image = intent.getIntArrayExtra("image")

        /*Gestion du menu de navigation*/
        MenuNavigation(this)



//        Recuperation des viw
        menuIV = findViewById(R.id.menuIV)
        menuCL= findViewById(R.id.menuCL)
        closeMenuIV= findViewById(R.id.closeMenuIV)
        detailPhotoRV= findViewById(R.id.detailPhotoRV)
        DetailsNomTV= findViewById(R.id.DetailsNomTV)
        DetailSIV= findViewById(R.id.DetailSIV)
        displayTextTV= findViewById(R.id.displayTextTV)
        DateTV = findViewById(R.id.DateTV)
        LieuTV = findViewById(R.id.LieuTV)
        PrimeTV = findViewById(R.id.PrimeTV)

        /*Initialisation des information de l'engin disparu concernée*/
        DetailsNomTV.text = imatriculation
        DetailSIV.setImageResource(image!![0])
        displayTextTV.text = displayText
        DateTV.text = date
        LieuTV.text = lieu
//        PrimeTV.text = ""


        /*Affichage des photos du RecyclerView*/
        val imgList:MutableList<Int> = mutableListOf()
        for (img in image){
            imgList.add(img)
        }
        var enginModel = EnginModel(imatriculation!!, date!!, displayText!!, prime, description!!, Contact!!, imgList)
        val adapter = DetailsEnginsAdapter(imgList,this)
        detailPhotoRV.apply {
            layoutManager = GridLayoutManager(this@DetailsEngins, 3)
            this.adapter = adapter
        }





        /*Actionnement du menu*/
        menuIV.setOnClickListener{
            YoYo.with(Techniques.BounceInLeft)
                .duration(1000)
                .onStart { menuCL.visibility = View.VISIBLE }
                .playOn(menuCL)
        }
        closeMenuIV.setOnClickListener{
            YoYo.with(Techniques.FadeOutLeft)
                .duration(1000)
                .onEnd { menuCL.visibility = View.GONE }
                .playOn(menuCL)
        }
        menuCL.setOnClickListener{
            YoYo.with(Techniques.FadeOutLeft)
                .duration(1000)
                .onEnd { menuCL.visibility = View.GONE }
                .playOn(menuCL)
        }

    }
}