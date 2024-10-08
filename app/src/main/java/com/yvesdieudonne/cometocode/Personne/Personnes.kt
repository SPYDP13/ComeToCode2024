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
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.yvesdieudonne.cometocode.Home.Personne.PersonAdapter
import com.yvesdieudonne.cometocode.Home.Personne.PersonneModel
import com.yvesdieudonne.cometocode.Home.Engins.MenuNavigation
import com.yvesdieudonne.cometocode.Personne.PersonneRetrouves.ListDesPersonnesRetrouves.ListDesPersonnesRetrouves
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
    lateinit var personneRetrouveBtn: Button
    var optionIsActive:Boolean = false
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personnes)

        /*Initialisation du menu*/
        MenuNavigation(this)

        /*Recuperation des Views*/
        RV = findViewById(R.id.RV)
        optionsCL = findViewById(R.id.optionsCL)
        optionsFab = findViewById(R.id.optionsFab)
        menuIV = findViewById(R.id.menuIV)
        menuCL= findViewById(R.id.menuCL)
        closeMenuIV= findViewById(R.id.closeMenuIV)
        nouvelleDeclarationBtn= findViewById(R.id.nouvelleDeclarationBtn)
        personneRetrouveBtn= findViewById(R.id.personneRetrouveBtn)


        /*Disposition des informations de la liste des personnes*/
        var personList = mutableListOf(
            PersonneModel("Sawadogo Yves Dieudonne", "15 Mai 2024", "Personne recherchée par sa famille", 50000, "Nous recherchons activement Sawadogo Yves Dieudonné, disparue depuis le 15 mai 2024. il a été vu pour la dernière fois dans la Zone du Bois. Sa famille et ses amis sont extrêmement inquiets et espèrent son retour sain et sauf.  Si vous avez des informations concernant sa disparition ou si vous l'avez aperçue, veuillez nous le signaler immediatement sur la plateformes s'il vous plait.  Merci de votre aide et de votre solidarité.", "+226 55220706", mutableListOf(R.drawable.personne1, R.drawable.personne2, R.drawable.personne3)
            ),
            PersonneModel("David Danaye", "16 Juin 2024", "Personne recherchée par sa famille", 0, "Nous recherchons activement Danaye David, disparue depuis le 16 juin 2024. il a été vu pour la dernière fois dans la Zone du Bois. Sa famille et ses amis sont extrêmement inquiets et espèrent son retour sain et sauf.  Si vous avez des informations concernant sa disparition ou si vous l'avez aperçue, veuillez nous le signaler immediatement sur la plateformes s'il vous plait.  Merci de votre aide et de votre solidarité.", "+226 55220706",
                mutableListOf(R.drawable.personne7, R.drawable.personne8, R.drawable.personne9)
            ),
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
        personneRetrouveBtn.setOnClickListener {
            Intent(this, ListDesPersonnesRetrouves::class.java).also {
                startActivity(it)
            }
        }



    }
}