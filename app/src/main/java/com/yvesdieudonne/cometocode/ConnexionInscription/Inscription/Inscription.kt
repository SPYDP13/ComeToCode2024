package com.yvesdieudonne.cometocode.ConnexionInscription.Inscription

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.yvesdieudonne.cometocode.ConnexionInscription.Connexion.Connexion
import com.yvesdieudonne.cometocode.Home.HomeActivity
import com.yvesdieudonne.cometocode.R

class Inscription : AppCompatActivity() {
    lateinit var connexionTV:TextView
    lateinit var HomeIV:ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription)

        connexionTV = findViewById(R.id.connexionTV)
        HomeIV = findViewById(R.id.HomeIV)

        connexionTV.setOnClickListener {
            Intent(this, Connexion::class.java).also {
                startActivity(it)
            }
        }

        HomeIV.setOnClickListener{
            Intent(this, HomeActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}