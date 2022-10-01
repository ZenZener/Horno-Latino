package com.example.vistaprincipal

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.vistaprincipal.fragmentos.ArgentinaFragment
import com.example.vistaprincipal.fragmentos.PeruFragment
import com.example.vistaprincipal.recetas.RecetasPeru
import kotlinx.android.synthetic.main.activity_seleccion_postre_arg.*
import kotlinx.android.synthetic.main.activity_seleccion_postre_arg.nav_view
import kotlinx.android.synthetic.main.activity_seleccion_postre_peru.*


class PostresPeru : AppCompatActivity() {
    private lateinit var toogle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {

        //val bundle = intent.extras
        //val pais = bundle?.getString("pais")
        //val pais = "Perú"

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seleccion_postre_peru)


        /*val botonSuspiro = findViewById<ImageButton>(R.id.imSuspiro)
        botonSuspiro.setOnClickListener{
            val lanzar2 = Intent(this, RecetasPeru::class.java)
            lanzar2.putExtra("pais", pais)
            lanzar2.putExtra("postre", "suspiro")
            startActivity(lanzar2)
        }

        val botonPicaron = findViewById<ImageButton>(R.id.imPicaron)
        botonPicaron.setOnClickListener{
            val lanzar3 = Intent(this, RecetasPeru::class.java)
            lanzar3.putExtra("pais", pais)
            lanzar3.putExtra("postre", "picaron")
            startActivity(lanzar3)
        }*/

        toogle = ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_arg ->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, ArgentinaFragment())
                        commit()
                    }
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)

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