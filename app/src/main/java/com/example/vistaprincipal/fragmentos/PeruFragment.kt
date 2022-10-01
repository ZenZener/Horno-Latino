package com.example.vistaprincipal.fragmentos

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.vistaprincipal.R
import com.example.vistaprincipal.recetas.RecetasPeru
import kotlinx.android.synthetic.main.activity_seleccion_postre_arg.*
import kotlinx.android.synthetic.main.fragment_peru.*

class PeruFragment : Fragment(R.layout.fragment_peru){


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val pais = "Perú"
        super.onViewCreated(view, savedInstanceState)

        imPicaron.setOnClickListener {
            val intent = Intent (getActivity(), RecetasPeru::class.java)
            intent.putExtra("pais", pais)
            intent.putExtra("postre", "picaron")
            getActivity()?.startActivity(intent)
        }

        imSuspiro.setOnClickListener {
            val intent = Intent (getActivity(), RecetasPeru::class.java)
            intent.putExtra("pais", pais)
            intent.putExtra("postre", "suspiro")
            getActivity()?.startActivity(intent)
        }



    }

}

