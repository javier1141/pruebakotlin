package com.solucionesj.facilfiado.Models

public class Deuda {

    lateinit var ID:String
    lateinit var Fecha:String
    lateinit var Cantidad:String
    lateinit var IDDeudor:String
    lateinit var Descripcion:String
    lateinit var IMG:String


    constructor(ID:String,Fecha:String,Cantidad:String,Descripcion:String,IDDeudor:String,IMG:String){
        this.ID=ID
        this.Fecha=Fecha
        this.Cantidad=Cantidad
        this.Descripcion=Descripcion
        this.IDDeudor=IDDeudor
        this.IMG=IMG
    }
}