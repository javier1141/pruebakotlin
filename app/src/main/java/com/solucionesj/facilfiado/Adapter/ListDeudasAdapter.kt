package com.solucionesj.facilfiado.Adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.solucionesj.facilfiado.Models.Deuda
import com.solucionesj.facilfiado.R
import com.squareup.picasso.Picasso


/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class ListDeudasAdapter(
    private val Data: List<Deuda>, private val View:View)
    : RecyclerView.Adapter<ListDeudasAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ListDeudasAdapter.ViewHolder {
        val View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_list_deudas, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return ViewHolder(View)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txt_recycle_ID_deuda.text = Data[position].ID
        holder.txt_recycle_fecha_deuda.text = Data[position].Fecha
        holder.txt_recycle_cantidad_deuda.text = Data[position].Cantidad

        holder.txt_recycle_iddeudor_deuda.text = Data[position].IDDeudor
        holder.txt_recycle_descripcion_deuda.text = Data[position].Descripcion

        try{
            if (Data[position].IMG!="")
            {
                val picasso= Picasso.get()
                picasso.load(Data[position].IMG).fit().centerCrop().error(R.drawable.ejemplo).into(holder.recycle_img_deudas)
            }
            else
            {
                val picasso= Picasso.get()
                picasso.load(R.drawable.ejemplo).fit().centerCrop().error(R.drawable.ejemplo).into(holder.recycle_img_deudas)
            }

        }
        catch(E:Exception)
        {
            Toast.makeText(View.context,E.message,Toast.LENGTH_LONG).show()
        }


    }

    override fun getItemCount() = Data.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recycle_img_deudas: ImageView
        val txt_recycle_ID_deuda: TextView
        val txt_recycle_fecha_deuda: TextView
        val txt_recycle_cantidad_deuda: TextView
        val txt_recycle_iddeudor_deuda: TextView
        val txt_recycle_descripcion_deuda: TextView

        init {
            // Define click listener for the ViewHolder's View.
            txt_recycle_fecha_deuda = view.findViewById(R.id.txt_recycle_fecha_deuda)
            txt_recycle_ID_deuda=view.findViewById(R.id.txt_recycle_ID_deuda)
            txt_recycle_cantidad_deuda=view.findViewById(R.id.txt_recycle_cantidad_deuda)
            txt_recycle_iddeudor_deuda=view.findViewById(R.id.txt_recycle_iddeudor_deuda)
            txt_recycle_descripcion_deuda=view.findViewById(R.id.txt_recycle_descripcion_deuda)
            recycle_img_deudas=view.findViewById(R.id.recycle_img_deudas)
        }
    }
}