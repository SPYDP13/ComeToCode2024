package com.yvesdieudonne.cometocode.Engins.EnginsRecherche.ListDesEnginsRecherche

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
import com.yvesdieudonne.cometocode.Engins.EnginsRecherche.DeclarationEnginsRecherche.DeclarationEnginsRecherche
import com.yvesdieudonne.cometocode.Home.Engins.EnginAdapter
import com.yvesdieudonne.cometocode.Home.Engins.EnginModel
import com.yvesdieudonne.cometocode.Home.Engins.MenuNavigation
import com.yvesdieudonne.cometocode.R

class ListDesEnginsRecherche : AppCompatActivity() {

    lateinit var RV: RecyclerView
    lateinit var optionsCL: ConstraintLayout
    lateinit var optionsFab: FloatingActionButton
    lateinit var menuIV: ImageView
    lateinit var menuCL: ConstraintLayout
    lateinit var closeMenuIV: ImageView
    lateinit var nouvelleDeclarationBtn: Button
    var optionIsActive:Boolean = false
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_des_engins_recherche)
        /*Recuperation des Views*/
        RV = findViewById(R.id.RV)
        optionsCL = findViewById(R.id.optionsCL)
        optionsFab = findViewById(R.id.optionsFab)
        menuIV = findViewById(R.id.menuIV)
        menuCL= findViewById(R.id.menuCL)
        closeMenuIV= findViewById(R.id.closeMenuIV)
        nouvelleDeclarationBtn= findViewById(R.id.nouvelleDeclarationBtn)

        /*Initialisation du menu*/
        MenuNavigation(this)


        /*Disposition des informations de la liste des personnes*/

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
        var enginAdapater: EnginAdapter = EnginAdapter(enginList, this)
        RV.adapter = enginAdapater

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
            Intent(this, DeclarationEnginsRecherche::class.java).also {
                startActivity(it)
            }
        }

    }
}