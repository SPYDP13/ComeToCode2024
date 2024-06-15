package com.yvesdieudonne.cometocode.Engins.EnginsRecherche.DeclarationEnginsRecherche

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
import com.yvesdieudonne.cometocode.MenuNavigation
import com.yvesdieudonne.cometocode.Personne.PersonnesRecherche.DeclarationPersonneRecherche.PhotoAdapter
import com.yvesdieudonne.cometocode.R

class DeclarationEnginsRecherche : AppCompatActivity() {
    lateinit var menuIV: ImageView
    lateinit var menuCL: ConstraintLayout
    lateinit var closeMenuIV: ImageView
    lateinit var photoRv: RecyclerView
    lateinit var addPhotoIb: ImageButton
    lateinit var calendarView: CalendarView
    lateinit var OpenCalendarIB: ImageButton
    lateinit var dateETD: EditText
    var calendarIsOpen:Boolean = false

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_declaration_engins_recherche)
        menuIV = findViewById(R.id.menuIV)
        menuCL= findViewById(R.id.menuCL)
        closeMenuIV= findViewById(R.id.closeMenuIV)
        photoRv = findViewById(R.id.photoRv)
        addPhotoIb = findViewById(R.id.addPhotoIb)
        calendarView = findViewById(R.id.calendarView)
        OpenCalendarIB = findViewById(R.id.OpenCalendarIB)
        dateETD = findViewById(R.id.dateETD)

        /*Initialisation du menu*/
        MenuNavigation(this)

        val bitmapList = mutableListOf<Bitmap>()


        /*Actionnement de la vue du calendrier*/
        OpenCalendarIB.setOnClickListener {
            if (!calendarIsOpen){
                YoYo.with(Techniques.BounceInUp)
                    .duration(1000)
                    .onStart { calendarView.visibility = View.VISIBLE }
                    .playOn(calendarView)
            }else{
                YoYo.with(Techniques.FadeOutDown)
                    .duration(1000)
                    .onEnd { calendarView.visibility = View.GONE }
                    .playOn(calendarView)
            }
            calendarIsOpen = !calendarIsOpen
        }

        calendarView.visibility = View.GONE
        calendarView.setOnDateChangeListener { calendarView, i, i2, i3 ->
            run {
                dateETD.setText("$i3-$i2-$i ")
            }
        }


        /*Actionnement de la liste des photos*/
        /*Adapter des RV*/
        var adapter = PhotoAdapter(bitmapList, this)
        photoRv.adapter = adapter

        /*Ouverture des fichiers du téléphone*/
        val GaleryOppening = registerForActivityResult(ActivityResultContracts.GetMultipleContents()){ datas ->
            /*Verification qu'au moins un fichier a été selectionner*/
            try {
                for (data in datas) {
                    val inputStream = contentResolver.openInputStream(data!!)
//                bitmapType = contentResolver.getType(data)!!
                    if (inputStream != null) {
                        var bitmap = BitmapFactory.decodeStream(inputStream)
                        bitmapList.add(bitmap)
                        adapter.notifyItemInserted(bitmapList.size-1)
                    }
                }
            }catch (error: Throwable){
                Toast.makeText(this, "Aucun Fichier selectionner", Toast.LENGTH_SHORT).show()
            }
        }


        addPhotoIb.setOnClickListener{
            GaleryOppening.launch("image/*")
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
