package com.yvesdieudonne.cometocode.Home

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.yvesdieudonne.cometocode.Home.Personne.PersonAdapter
import com.yvesdieudonne.cometocode.Home.Personne.PersonneModel
import com.yvesdieudonne.cometocode.R

class HomeActivity : AppCompatActivity() {
    lateinit var personRv: RecyclerView
    lateinit var enginRv: RecyclerView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        /*Initialisation des views*/
        personRv = findViewById(R.id.personRv)
        enginRv = findViewById(R.id.enginRv)

        /*Disposition des informations de la liste des personnes*/
        var personList = mutableListOf(
            PersonneModel("Sawadogo Yves Dieudonne", "15 Mai 2024", "Personne recherchée par sa famille", 50000, "", "+226 55220706",
                mutableListOf(R.drawable.photo1, R.drawable.photo2, R.drawable.photo3)
            ),
            PersonneModel("Sawadogo Djémine Somzy", "18 Mai 2024", "Personne retrouvées par un citoyen", 10000, "", "+226 55220706",
                mutableListOf(R.drawable.photo1, R.drawable.photo2, R.drawable.photo3)
            ),
            PersonneModel("David Danaye", "16 Juin 2024", "Personne recherchée par sa famille", 0, "", "+226 55220706",
                mutableListOf(R.drawable.photo1, R.drawable.photo2, R.drawable.photo3)
            ),
            PersonneModel("Yankine Eliel", "16 Juin 2024", "Personne retrouvées par un citoyen", 0, "", "+226 55220706",
                mutableListOf(R.drawable.photo1, R.drawable.photo2, R.drawable.photo3)
            )
        )

        var personAdapter:PersonAdapter = PersonAdapter(personList, this)
        personRv.adapter = personAdapter


    }
}