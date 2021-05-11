package com.solucionesj.facilfiado.Fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.solucionesj.facilfiado.Adapter.ListPersonasAdapter
import com.solucionesj.facilfiado.Models.Persona
import com.solucionesj.facilfiado.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListaPersonaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaPersonaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        var Vista=inflater.inflate(R.layout.fragment_pagina_lista_persona, container, false)
        viewManager = LinearLayoutManager(Vista.context)

        var Datos = mutableListOf<Persona>()

        Datos.add(Persona("MAMA","MIMAMAMEMIMA","SOY UN COJUDO","https://static.wikia.nocookie.net/shingeki-no-kyojin/images/f/f5/Uri_Reiss_%28anime%29.png/revision/latest/scale-to-width-down/800?cb=20180923231001&path-prefix=es"))

        viewAdapter = ListPersonasAdapter(Datos,Vista)

        recyclerView = Vista.findViewById<RecyclerView>(R.id.recycle_ListPersonas).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
        return Vista
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PaginaListaPersona.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListaPersonaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}