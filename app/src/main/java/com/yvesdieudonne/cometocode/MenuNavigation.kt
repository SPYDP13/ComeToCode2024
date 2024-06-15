package com.yvesdieudonne.cometocode

import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.imageview.ShapeableImageView
import com.yvesdieudonne.cometocode.ConnexionInscription.Connexion.Connexion
import com.yvesdieudonne.cometocode.Engins.EnginsRecherche.EnginsRecherche
import com.yvesdieudonne.cometocode.Home.HomeActivity
import com.yvesdieudonne.cometocode.Personne.Personnes

class MenuNavigation(var mContext:AppCompatActivity) {
    init {

        var AccueilBtn:Button = mContext.findViewById(R.id.AccueilBtn)
        var PersonneBtn:Button = mContext.findViewById(R.id.PersonneBtn)
        var EnginBtn:Button = mContext.findViewById(R.id.EnginBtn)
        var entourageBtn:Button = mContext.findViewById(R.id.entourageBtn)
        var AccountBtn:Button = mContext.findViewById(R.id.AccountBtn)
        var DeconnectBtn:Button = mContext.findViewById(R.id.DeconnectBtn)
        var profilSIV:ShapeableImageView = mContext.findViewById(R.id.profilSIV)

        AccueilBtn.setOnClickListener {
            Intent(mContext, HomeActivity::class.java).also { mContext.startActivity(it) }
        }
        PersonneBtn.setOnClickListener {
            Intent(mContext, Personnes::class.java).also { mContext.startActivity(it) }
        }
        EnginBtn.setOnClickListener {
            Intent(mContext, EnginsRecherche::class.java).also { mContext.startActivity(it) }
        }
        profilSIV.setOnClickListener {
            Intent(mContext, Connexion::class.java).also {
                mContext.startActivity(it)
            }
        }


    }


}