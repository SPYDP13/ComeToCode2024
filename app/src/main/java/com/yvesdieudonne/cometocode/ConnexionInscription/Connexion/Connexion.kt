package com.yvesdieudonne.cometocode.ConnexionInscription.Connexion

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.yvesdieudonne.cometocode.ConnexionInscription.Inscription.Inscription
import com.yvesdieudonne.cometocode.Home.HomeActivity
import com.yvesdieudonne.cometocode.R

class Connexion : AppCompatActivity() {
    lateinit var inscriptionTV:TextView
    lateinit var HomeIV:ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connexion)
        inscriptionTV = findViewById(R.id.inscriptionTV)
        HomeIV = findViewById(R.id.HomeIV)

        inscriptionTV.setOnClickListener {
            Intent(this, Inscription::class.java).also{
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