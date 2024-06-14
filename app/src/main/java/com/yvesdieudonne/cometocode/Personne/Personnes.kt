package com.yvesdieudonne.cometocode.Personne

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.yvesdieudonne.cometocode.Home.Personne.PersonAdapter
import com.yvesdieudonne.cometocode.Home.Personne.PersonneModel
import com.yvesdieudonne.cometocode.Personne.PersonnesRecherche.DeclarationPersonneRecherche.DeclarationPersonneRecherche
import com.yvesdieudonne.cometocode.R

class Personnes : AppCompatActivity() {
    lateinit var RV:RecyclerView
    lateinit var optionsCL:ConstraintLayout
    lateinit var optionsFab:FloatingActionButton
    lateinit var menuIV: ImageView
    lateinit var menuCL: ConstraintLayout
    lateinit var closeMenuIV: ImageView
    lateinit var nouvelleDeclarationBtn: Button
    var optionIsActive:Boolean = false
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personnes)

        /*Recuperation des Views*/
        RV = findViewById(R.id.RV)
        optionsCL = findViewById(R.id.optionsCL)
        optionsFab = findViewById(R.id.optionsFab)
        menuIV = findViewById(R.id.menuIV)
        menuCL= findViewById(R.id.menuCL)
        closeMenuIV= findViewById(R.id.closeMenuIV)
        nouvelleDeclarationBtn= findViewById(R.id.nouvelleDeclarationBtn)


        /*Disposition des informations de la liste des personnes*/
        var personList = mutableListOf(
            PersonneModel("Sawadogo Yves Dieudonne", "15 Mai 2024", "Personne recherchée par sa famille", 50000, "", "+226 55220706",
                mutableListOf(R.drawable.personne1, R.drawable.personne2, R.drawable.personne3)
            ),
            PersonneModel("Sawadogo Djémine Somzy", "18 Mai 2024", "Personne retrouvées par un citoyen", 10000, "", "+226 55220706",
                mutableListOf(R.drawable.personne4, R.drawable.personne5, R.drawable.personne6)
            ),
            PersonneModel("David Danaye", "16 Juin 2024", "Personne recherchée par sa famille", 0, "", "+226 55220706",
                mutableListOf(R.drawable.personne7, R.drawable.personne8, R.drawable.personne9)
            ),
            PersonneModel("Yankine Eliel", "16 Juin 2024", "Personne retrouvées par un citoyen", 0, "", "+226 55220706",
                mutableListOf(R.drawable.personne1, R.drawable.personne2, R.drawable.personne3)
            )
        )

        var personAdapter = PersonAdapter(personList, this)
        RV.adapter = personAdapter

        /*Disposition des option*/
        optionsFab.setOnClickListener {
            if (!optionIsActive){
                YoYo.with(Techniques.FadeInUp)
                    .duration(1000)
                    .onStart {
                        optionsCL.visibility = View.VISIBLE
                        optionsFab.rotation= 0f
                        optionsFab.animate().apply {
                            duration = 500
                            rotation(180f)
                        }
                    }
                    .playOn(optionsCL)

            }else{
                YoYo.with(Techniques.FadeOutDown)
                    .duration(1000)
                    .onEnd {
                        optionsCL.visibility = View.GONE
                        optionsFab.rotation= 180f
                        optionsFab.animate().apply {
                            duration = 500
                            rotation(0f)
                        }
                    }
                    .playOn(optionsCL)
            }
            optionIsActive = !optionIsActive
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


       /*Buttons*/
        nouvelleDeclarationBtn.setOnClickListener {
            Intent(this, DeclarationPersonneRecherche::class.java).also {
                startActivity(it)
            }
        }



    }
}