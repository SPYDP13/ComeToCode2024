package com.yvesdieudonne.cometocode.Personne.PersonneRetrouves.PersonnesRetrouvesCasResolus

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.yvesdieudonne.cometocode.Personne.PersonnesRecherche.DeclarationPersonneRecherche.PhotoAdapter
import com.yvesdieudonne.cometocode.R

class PersonnesRetrouvesCasResolus : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_personnes_retrouves_cas_resolus)

    }
}