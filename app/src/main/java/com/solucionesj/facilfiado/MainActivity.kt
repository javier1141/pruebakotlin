package com.solucionesj.facilfiado

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.solucionesj.facilfiado.Activities.ListPersonActivity
import com.solucionesj.facilfiado.Dialog.DialogAdapter
import com.solucionesj.facilfiado.Global.Global
import kotlinx.coroutines.*
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {
    lateinit var txt_ID : EditText
    lateinit var txt_password : EditText
    lateinit var btn_entrar:Button
    lateinit var UID:String
    lateinit var dialog: DialogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt_ID= findViewById<EditText>(R.id.txt_ID)
        txt_password= findViewById<EditText>(R.id.txt_password)
        btn_entrar=findViewById<Button>(R.id.btn_entrar)
        txt_ID.setText("javierpastortl@gmail.com")
        txt_password.setText("k015362036")
        dialog= DialogAdapter()
    }

     fun onclick(view: View) {

            if(txt_ID.text.isNotEmpty()&&txt_password.text.isNotEmpty())
            {
                dialog.showDialog("Comienzo","cargando",this)
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(
                            txt_ID.text.toString(),
                            txt_password.text.toString()
                    ).addOnCompleteListener{

                        if(it.isSuccessful){
                            UID=""
                            try{

                                val CurrentUser = FirebaseAuth.getInstance().currentUser
                                if(CurrentUser!=null){
                                    UID=CurrentUser.uid

                                }
                                Thread.sleep(5*1000);
                                Global.UID=UID
                            }
                            catch(E:Exception){
                                Global.UID=""
                            }

                            dialog.closeDialog()
                            var intent= Intent(this, ListPersonActivity::class.java)
                            startActivity(intent)

                        }
                        else
                        {
                            Global.UID=""
                            dialog.closeDialog()
                        }

                    }

            }

     }



}