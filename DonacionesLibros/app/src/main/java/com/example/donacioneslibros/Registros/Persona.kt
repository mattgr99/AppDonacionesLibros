package com.example.donacioneslibros.Registros

class Persona() {
        private var  cedula:String?=null
        private var  nombre:String?=null
        private var  telefono:String?=null
        private var  direccion:String?=null


        constructor(ced:String,nom:String,tel:String,dir:String):this(){
            this.cedula=ced
            this.nombre=nom
            this.telefono=tel
            this.direccion=dir

        }

        fun getCedula():String{
            return this.cedula!!
        }
        fun getNombre():String{
            return this.nombre!!
        }
        //principio KOTLIN - llamado codigo limpio
        //  tambian llamado expreciones LANDA
        fun getTelefono():String{
            return this.telefono!!
        }
        fun getDireccion():String{
            return this.direccion!!
        }


        fun setCedula(cedula:String){this.cedula = cedula}
        fun setNombre(nombre:String){this.nombre = nombre}
        fun setTelefono(telefono:String){this.telefono = telefono}
        fun setDireccion(direccion:String){this.direccion = direccion}




}