package com.yvesdieudonne.cometocode.Home

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
import com.yvesdieudonne.cometocode.Engins.EnginsRecherche.ListDesEnginsRecherche.ListDesEnginsRecherche
import com.yvesdieudonne.cometocode.Home.Engins.EnginAdapter
import com.yvesdieudonne.cometocode.Home.Personne.PersonAdapter
import com.yvesdieudonne.cometocode.Home.Engins.EnginModel
import com.yvesdieudonne.cometocode.Home.Personne.PersonneModel
import com.yvesdieudonne.cometocode.Home.Engins.MenuNavigation
import com.yvesdieudonne.cometocode.Personne.Personnes
import com.yvesdieudonne.cometocode.R

class HomeActivity : AppCompatActivity() {
    lateinit var personRv: RecyclerView
    lateinit var enginRv: RecyclerView
    lateinit var menuIV: ImageView
    lateinit var menuCL: ConstraintLayout
    lateinit var closeMenuIV: ImageView

    lateinit var personneVoirPlus:Button
    lateinit var enginVoirPlus:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        /*Initialisation du menu*/
        MenuNavigation(this)

        /*Initialisation des views*/
        personRv = findViewById(R.id.personRv)
        enginRv = findViewById(R.id.enginRv)
        personneVoirPlus = findViewById(R.id.personneVoirPlus)
        enginVoirPlus = findViewById(R.id.enginVoirPlus)
        menuIV = findViewById(R.id.menuIV)
        menuCL= findViewById(R.id.menuCL)
        closeMenuIV= findViewById(R.id.closeMenuIV)



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

        var personAdapter:PersonAdapter = PersonAdapter(personList, this)
        personRv.adapter = personAdapter
        personneVoirPlus.setOnClickListener {
            Intent(this, Personnes::class.java).also { startActivity(it) }
        }


        /*Disposition des informations de la liste des engins*/
        var enginList = mutableListOf(
            EnginModel("06 BF 5478", "15 Mai 2024", "Engin recherché par son proprietaire", 50000, "", "+226 55220706",
                mutableListOf(R.drawable.engin1, R.drawable.engin2, R.drawable.engin3)
            ),
            EnginModel("10 BF 5952", "18 Mai 2024", "Engin recherché par son proprietaire", 10000, "", "+226 55220706",
                mutableListOf(R.drawable.engin2, R.drawable.engin1, R.drawable.engin3)
            ),
            EnginModel("11 SR 5478", "16 Juin 2024", "Engin recherché par son proprietaire", 0, "", "+226 55220706",
                mutableListOf(R.drawable.engin3, R.drawable.engin1, R.drawable.engin2)
            ),
            EnginModel("12 BF 5789", "16 Juin 2024", "Engin recherché par son proprietaire", 0, "", "+226 55220706",
                mutableListOf(R.drawable.engin1, R.drawable.engin2, R.drawable.engin3)
            )
        )
        var enginAdapater:EnginAdapter = EnginAdapter(enginList, this)
        enginRv.adapter = enginAdapater
        enginVoirPlus.setOnClickListener {
            Intent(this, ListDesEnginsRecherche::class.java).also { startActivity(it) }
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