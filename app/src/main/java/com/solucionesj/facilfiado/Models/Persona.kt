package com.solucionesj.facilfiado.Models

class Persona {
    lateinit var ID:String
    lateinit var Nombre:String
    lateinit var Descripcion:String
    lateinit var Img:String

    constructor(ID:String,Nombre:String,Descripcion:String,Img:String) {
        this.ID=ID
        this.Nombre=Nombre
        this.Descripcion=Descripcion
        this.Img=Img
    }

    constructor(){
        this.ID=""
        this.Nombre=""
        this.Descripcion=""
        this.Img=""
    }




}