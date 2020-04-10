package com.example.donacioneslibros.Registros

class Libros() {
    private var  codigo:String?=null
    private var  categoria:String?=null
    private var  cantidad:String?=null


    constructor(cod:String,cat:String,cant:String):this(){
        this.codigo=cod
        this.categoria=cat
        this.cantidad=cant

    }

    fun getCodigo():String{
        return this.codigo!!
    }
    fun getCategoria():String{
        return this.categoria!!
    }
    //principio KOTLIN - llamado codigo limpio
    //  tambian llamado expreciones LANDA
    fun getCantidad():String{
        return this.cantidad!!
    }



    fun setCodigo(codigo:String){this.codigo = codigo}
    fun setCategoria(categoria:String){this.categoria = categoria}
    fun setCantidad(cantidad:String){this.cantidad = cantidad}


}