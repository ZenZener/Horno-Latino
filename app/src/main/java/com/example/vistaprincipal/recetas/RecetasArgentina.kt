package com.example.vistaprincipal.recetas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.vistaprincipal.R
import com.example.vistaprincipal.PostresArgentina
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_recetasargentina.*

class RecetasArgentina : AppCompatActivity()  {
    val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        val bundle = intent.extras
        val pais = bundle?.getString("pais")
        val postre = bundle?.getString("postre")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recetasargentina)

        val botonVolver = findViewById<ImageView>(R.id.volver4)
        botonVolver.setOnClickListener{
            val lanzar1 = Intent(this, PostresArgentina::class.java)
            //devuelve el pais en el que está la receta
            lanzar1.putExtra("pais", pais)
            startActivity(lanzar1)
        }
        db.collection("paises").document(pais.toString())
            .collection("recetas").document(postre.toString()).get().addOnSuccessListener {
            textViewDescripcion.setText(it.get("descripcion") as String?)
            textViewTituloReceta.setText(it.get("titulo") as String?)
            textViewNombreReceta.setText(it.get("nombre") as String?)
            textViewTituloIngrediente.setText(it.get("tituloingrediente") as String?)
            textViewIngredientes.setText(it.get("ingredientes") as String?)

        }
    }
}