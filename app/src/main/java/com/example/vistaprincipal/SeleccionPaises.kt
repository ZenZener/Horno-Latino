package com.example.vistaprincipal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.vistaprincipal.databinding.ActivityMainBinding


class SeleccionPaises : AppCompatActivity(), AdapterView.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(500)
        setTheme(R.style.Apptheme)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val paises = resources.getStringArray(R.array.pais)
        val adapter = ArrayAdapter(
            this,
            R.layout.list_item_menu,
            paises
        )

        with(binding.autoCompleteTextView){
            setAdapter(adapter)
            onItemClickListener = this@SeleccionPaises
        }


    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item = parent?.getItemAtPosition(position).toString()
        if (item == "Argentina"){
            val lanzar1 = Intent(this, PostresArgentina::class.java)
            //lanzar1.putExtra("pais",item)
            startActivity(lanzar1)
        }else{
            val lanzar2 = Intent(this, PostresPeru::class.java)
            //lanzar2.putExtra("pais",item)
            startActivity(lanzar2)
        }
        //Toast.makeText(this@SeleccionPaises, item, Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        SweetAlertDialog(this@SeleccionPaises, SweetAlertDialog.WARNING_TYPE)
            .setTitleText("Has oprimido el botón salir")
            .setContentText("¿Está seguro qué quiere salir?")
            .setCancelText("No, cancelar")
            .setConfirmText("Si, salir")
            .setConfirmButton(
                "Si, salir"
            ) { sDialog -> System.exit(0) }
            .setCancelButton(
                "No, cancelar"
            ) { sDialog -> sDialog.dismissWithAnimation() }
            .show()
    }

}