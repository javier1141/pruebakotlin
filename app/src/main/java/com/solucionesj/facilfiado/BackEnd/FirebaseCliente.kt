package com.solucionesj.facilfiado.BackEnd

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.solucionesj.facilfiado.Global.Global

class FirebaseCliente (){

    lateinit var database: DatabaseReference

    public fun NuevoCliente(){

        database = Firebase.database.reference
        var key=database.push().key
        database.child("Cliente").child(Global.UID.toString()).child(key.toString()).child("Nombre").setValue("Juan Alberto")

    }
}