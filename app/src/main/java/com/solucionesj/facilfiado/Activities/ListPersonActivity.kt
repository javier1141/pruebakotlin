package com.solucionesj.facilfiado.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.solucionesj.facilfiado.Fragmentos.ListDeudasFragment
import com.solucionesj.facilfiado.Fragmentos.ListaPersonaFragment
import com.solucionesj.facilfiado.R
import com.solucionesj.facilfiado.BackEnd.FirebaseCliente
import kotlinx.coroutines.*

class ListPersonActivity : AppCompatActivity() {

    lateinit var dialog:android.app.Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_person)


        val fragcliente=ListaPersonaFragment()
        val fragdeudas=ListDeudasFragment()


        val btnnav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        loadFragment(fragcliente)
        btnnav.setOnNavigationItemSelectedListener {
            when(it.itemId){
               R.id.item_Clientes->{
                   loadFragment(fragcliente)

                   return@setOnNavigationItemSelectedListener true
               }
               R.id.item_Deudas->{
                   loadFragment(fragdeudas)
                   return@setOnNavigationItemSelectedListener true
               }
                else -> true
            }

        }

       var job= this.lifecycleScope.launch(Dispatchers.IO) {

            var deferent= async {
                CrearCliente()
            }.await()
        }

    }


    private fun CrearCliente(){

            var cliente:FirebaseCliente= FirebaseCliente()
            cliente.NuevoCliente()
    }




    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment1, fragment)
        //transaction.addToBackStack(null)
        transaction.commit()
    }
}