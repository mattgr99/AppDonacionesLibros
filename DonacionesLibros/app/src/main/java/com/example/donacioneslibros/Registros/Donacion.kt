package com.example.donacioneslibros.Registros

class Donacion() {
    private var  codigo1:String?=null
    private var  codigo2:String?=null
    private var  cantidad1:String?=null
    private var  fecha:String?=null

    constructor(cod1:String,cod2:String,cant:String,fec:String):this(){
        this.codigo1=cod1
        this.codigo2=cod2
        this.cantidad1=cant
        this.fecha=fec

    }

    fun getCodigo1():String{
        return this.codigo1!!
    }
    fun getCodigo2():String{
        return this.codigo2!!
    }
    //principio KOTLIN - llamado codigo limpio
    //  tambian llamado expreciones LANDA
    fun getCantidad1():String{
        return this.cantidad1!!
    }
    fun getFecha():String{
        return this.fecha!!
    }

    fun setCodigo1(codigo1:String){this.codigo1 = codigo1}
    fun setCodigo2(codigo2:String){this.codigo2 = codigo2}
    fun setCantidad1(cantidad:String){this.cantidad1 = cantidad}
    fun setFecha(fecha:String){this.fecha = fecha}




}