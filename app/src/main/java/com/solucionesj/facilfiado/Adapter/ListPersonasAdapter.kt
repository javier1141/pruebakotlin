package com.solucionesj.facilfiado.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.solucionesj.facilfiado.Models.Persona
import com.solucionesj.facilfiado.R
import com.squareup.picasso.Picasso

class ListPersonasAdapter(private val Datos: List<Persona>, private val View:View) :
    RecyclerView.Adapter<ListPersonasAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ListPersonasAdapter.MyViewHolder {
        // create a new view
        val View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_personas, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(View)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.txt_recycle_ID.text = Datos[position].ID
        holder.txt_recycle_Nombre.text = Datos[position].Nombre
        holder.txt_recycle_descripcion.text = Datos[position].Descripcion

        try{
            if (Datos[position].Img!="")
            {
                val picasso= Picasso.get()
                picasso.load(Datos[position].Img).fit().centerCrop().error(R.drawable.ejemplo).into(holder.recycle_img)
            }
            else
            {
                val picasso= Picasso.get()
                picasso.load(R.drawable.ejemplo).fit().centerCrop().error(R.drawable.ejemplo).into(holder.recycle_img)
            }

        }
        catch(E:Exception)
        {
            Toast.makeText(View.context,E.message, Toast.LENGTH_LONG).show()
        }



    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = Datos.size

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txt_recycle_ID: TextView
        val txt_recycle_Nombre: TextView
        val txt_recycle_descripcion: TextView
        val recycle_img: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            txt_recycle_ID = view.findViewById(R.id.txt_recycle_ID)
            txt_recycle_Nombre=view.findViewById(R.id.txt_recycle_Nombre)
            txt_recycle_descripcion=view.findViewById(R.id.txt_recycle_descripcion)
            recycle_img=view.findViewById(R.id.recycle_img)
        }
    }
}