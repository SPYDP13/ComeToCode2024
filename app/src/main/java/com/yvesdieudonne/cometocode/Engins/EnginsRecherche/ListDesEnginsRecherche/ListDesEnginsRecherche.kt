package com.yvesdieudonne.cometocode.Engins.EnginsRecherche.ListDesEnginsRecherche

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
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
    }
}