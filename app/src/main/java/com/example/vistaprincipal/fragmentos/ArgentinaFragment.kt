package com.example.vistaprincipal.fragmentos

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vistaprincipal.R
import com.example.vistaprincipal.recetas.RecetasArgentina
import com.example.vistaprincipal.recetas.RecetasPeru
import kotlinx.android.synthetic.main.fragment_argentina.*

class ArgentinaFragment : Fragment(R.layout.fragment_argentina) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val pais = "Argentina"
        super.onViewCreated(view, savedInstanceState)

        imChocotorta.setOnClickListener {
            val intent = Intent (getActivity(), RecetasArgentina::class.java)
            intent.putExtra("pais", pais)
            intent.putExtra("postre", "Chocotorta")
            getActivity()?.startActivity(intent)
        }

        imPastelitos.setOnClickListener {
            val intent = Intent (getActivity(), RecetasArgentina::class.java)
            intent.putExtra("pais", pais)
            intent.putExtra("postre", "pastelito")
            getActivity()?.startActivity(intent)
        }

    }

}