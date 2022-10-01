package com.example.vistaprincipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.vistaprincipal.fragmentos.PeruFragment
import com.example.vistaprincipal.recetas.RecetasArgentina
import kotlinx.android.synthetic.main.activity_seleccion_postre_arg.*

class PostresArgentina : AppCompatActivity() {
    private lateinit var toogle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seleccion_postre_arg)
        //val bundle = intent.extras
       // val pais = bundle?.getString("pais")
       // val pais = "Argentina"

        /*val botonVolver = findViewById<ImageView>(R.id.imVolver)
        botonVolver.setOnClickListener{
            val lanzar1 = Intent(this, SeleccionPaises::class.java)
            startActivity(lanzar1)
        }*/

        /*val botonChoco = findViewById<ImageView>(R.id.imChocotorta)
        botonChoco.setOnClickListener{
            val lanzar2 = Intent(this, RecetasArgentina::class.java)
            lanzar2.putExtra("pais", pais)
            lanzar2.putExtra("postre", "Chocotorta")
            startActivity(lanzar2)
        }*/

       /* val botonPastelito = findViewById<ImageView>(R.id.imPastelitos)
        botonPastelito.setOnClickListener{
            val lanzar3 = Intent(this, RecetasArgentina::class.java)
            lanzar3.putExtra("pais", pais)
            lanzar3.putExtra("postre", "pastelito")
            startActivity(lanzar3)
        }*/

        toogle = ActionBarDrawerToggle(this, draweLayout, R.string.open_drawer, R.string.close_drawer)
        draweLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_peru ->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, PeruFragment())
                        commit()
                    }
                }
            }
            draweLayout.closeDrawer(GravityCompat.START)

            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item)){
            return true
        }


        return super.onOptionsItemSelected(item)
    }

}