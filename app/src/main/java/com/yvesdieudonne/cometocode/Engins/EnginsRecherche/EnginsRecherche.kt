package com.yvesdieudonne.cometocode.Engins.EnginsRecherche

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
import com.yvesdieudonne.cometocode.Personne.PersonnesRecherche.DeclarationPersonneRecherche.DeclarationPersonneRecherche
import com.yvesdieudonne.cometocode.R

class EnginsRecherche : AppCompatActivity() {
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
        setContentView(R.layout.activity_engins_recherche)



    }
}