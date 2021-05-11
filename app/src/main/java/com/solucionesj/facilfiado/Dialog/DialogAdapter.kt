package com.solucionesj.facilfiado.Dialog

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.solucionesj.facilfiado.R

class DialogAdapter {

    lateinit var messageBoxInstance: AlertDialog

    fun showDialog(title: String,cuerpo:String,activity:AppCompatActivity) {

        val messageBoxView = LayoutInflater.from(activity).inflate(R.layout.custom_dialog, null)
        val messageBoxBuilder = AlertDialog.Builder(activity).setView(messageBoxView)
        var tile=messageBoxView.findViewById<TextView>(R.id.tvTitle)
        var body=messageBoxView.findViewById<TextView>(R.id.tvBody)
        tile.text = title
        body.text=cuerpo
        messageBoxView.isClickable=false
        messageBoxInstance = messageBoxBuilder.show()

    }

    fun closeDialog(){
        messageBoxInstance.dismiss()
    }
}