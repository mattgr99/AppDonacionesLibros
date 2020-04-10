package com.example.donacioneslibros.GestionBddDonacioes

import android.content.Context
import android.widget.Toast
import com.android.dataframework.DataFramework
import com.android.dataframework.Entity
import com.example.donacioneslibros.Registros.Donacion
import com.example.donacioneslibros.Registros.Libros
import com.example.donacioneslibros.Registros.Persona

class ProcesosDonaciones () {
    private var idpersona:Long=-1
    private var  cantidad:String?=null
    private var numero:Int=0
    private var ingreso:Int=0
    private var limite:Int=0

    constructor(id:Long,cant:String,n:Int,in1:Int,res:Int):this(){
        this.idpersona=id
        this.cantidad=cant
        this.numero=n
        this.ingreso=in1
        this.limite=res

    }
    fun InsertarBeneficiario (agenda : Persona,contexto: Context?){
        //DataFramework.getInstance().open(contexto, "com.example.acceso_bdd_framework")
        var ent: Entity = Entity("beneficiario")
        ent.setValue("codigo_ben", agenda.getCedula())
        ent.setValue("nombre_ben", agenda.getNombre())
        ent.setValue("telefono_ben", agenda.getTelefono())
        ent.setValue("direccion_ben", agenda.getDireccion())
        Toast.makeText(contexto,"Se inserto correctamente", Toast.LENGTH_SHORT).show()
        ent.save()

    }
    fun InsertarDonante (agenda : Persona,contexto: Context?){
        //DataFramework.getInstance().open(contexto, "com.example.acceso_bdd_framework")
        var ent: Entity = Entity("donante")
        ent.setValue("cedula_don", agenda.getCedula())
        ent.setValue("nombre_don", agenda.getNombre())
        ent.setValue("telefono_don", agenda.getTelefono())
        ent.setValue("direccion_don", agenda.getDireccion())
        Toast.makeText(contexto,"Se inserto correctamente", Toast.LENGTH_SHORT).show()
        ent.save()

    }

    fun ConsultarBeneficiario(contexto: Context?):ArrayList<Persona>{
        var listado=ArrayList<Persona>()
        var personas:List<Entity> = DataFramework.getInstance().getEntityList("beneficiario")
        var iter : Iterator<Entity> = personas.iterator()
        var p=Persona()
        while (iter.hasNext()){
            var ent: Entity =iter.next()
            p=Persona(ent.getString("codigo_ben"),ent.getString("nombre_ben"),ent.getString("telefono_ben"),ent.getString("direccion_ben"))

            listado.add(p)

        }
        return listado
    }

    fun ConsultarDonante(contexto: Context?):ArrayList<Persona>{
        var listado=ArrayList<Persona>()
        var personas:List<Entity> = DataFramework.getInstance().getEntityList("donante")
        var iter : Iterator<Entity> = personas.iterator()
        var p=Persona()
        while (iter.hasNext()){
            var ent: Entity =iter.next()
            p=Persona(ent.getString("cedula_don"),ent.getString("nombre_don"),ent.getString("telefono_don"),ent.getString("direccion_don"))

            listado.add(p)

        }
        return listado
    }
    fun ConsultarBeneficiario(cedula:String):Long{

        var idbeneficiario:Long=-1
        var persona:List<Entity> = DataFramework.getInstance().getEntityList("beneficiario","codigo_ben='"+cedula+"'")
        var iter : Iterator<Entity> = persona.iterator()

        while (iter.hasNext()){

            var ent:Entity=iter.next()



            idbeneficiario=ent.id
        }

        return    idbeneficiario
    }
    fun ConsultarDonante(cedula:String):Long{

        var iddonante:Long=-1
        var persona:List<Entity> = DataFramework.getInstance().getEntityList("donante","cedula_don='"+cedula+"'")
        var iter : Iterator<Entity> = persona.iterator()

        while (iter.hasNext()){

            var ent:Entity=iter.next()



            iddonante=ent.id
        }

        return    iddonante
    }

    fun ConsultarDonante(contexto: Context?,cedula:String):Persona{

        var nom:String=""
        var dir:String=""
        var telf:String=""
        var persona1:List<Entity> = DataFramework.getInstance().getEntityList("donante","cedula_don='"+cedula+"'")
        var iter : Iterator<Entity> = persona1.iterator()
        while (iter.hasNext()){

            var ent: Entity =iter.next()

            nom=ent.getString("nombre_don")
            telf=ent.getString("telefono_don")
            dir=ent.getString("direccion_don")


        }


        return    Persona(cedula,nom,telf,dir)
    }
fun ConsultarBeneficiario(contexto: Context?,cedula:String):Persona{

        var idpersona:Long=-1
        var nom:String=""
        var dir:String=""
        var telf:String=""
        var persona:List<Entity> = DataFramework.getInstance().getEntityList("beneficiario","codigo_ben='"+cedula+"'")
        var iter : Iterator<Entity> = persona.iterator()
        while (iter.hasNext()){

            var ent: Entity =iter.next()

            nom=ent.getString("nombre_ben")
            telf=ent.getString("telefono_ben")
            dir=ent.getString("direccion_ben")


            idpersona=ent.id
        }


        ingreso=1
        return    Persona(cedula,nom,telf,dir)
    }

    fun ConsultarLibro(codigo:String):Long{

        var idlibro:Long=-1
        var lib:List<Entity> = DataFramework.getInstance().getEntityList("libros","codigo_lib='"+codigo+"'")
        var iter : Iterator<Entity> = lib.iterator()

        while (iter.hasNext()){

            var ent:Entity=iter.next()
            cantidad=ent.getString("cantidad_lib")


            idlibro=ent.id
        }
        if (idlibro > -1){

            numero=cantidad.toString().toInt()
        }

        return    idlibro
    }

    fun ConsultarLibro(contexto: Context?):ArrayList<Libros>{
        var listado=ArrayList<Libros>()
        var libros:List<Entity> = DataFramework.getInstance().getEntityList("libros")
        var iter : Iterator<Entity> = libros.iterator()
        var p=Libros()
        while (iter.hasNext()){
            var ent: Entity =iter.next()
            p=Libros(ent.getString("codigo_lib"),ent.getString("categoria_lib"),ent.getString("cantidad_lib"))

            listado.add(p)

        }
        return listado
    }

    fun InsertarLibro (agenda : Libros,contexto: Context?){
        //DataFramework.getInstance().open(contexto, "com.example.acceso_bdd_framework")
        var ent: Entity = Entity("libros")
        ent.setValue("codigo_lib", agenda.getCodigo())
        ent.setValue("categoria_lib", agenda.getCategoria())
        ent.setValue("cantidad_lib", agenda.getCantidad())
        Toast.makeText(contexto,"Se inserto correctamente", Toast.LENGTH_SHORT).show()
        ent.save()

    }

    fun ActualizarLibro(contexto: Context?,id1:Long,cantidad:String){
        var sum:Int=cantidad.toString().toInt()+numero
        var resta:Int=numero-cantidad.toString().toInt()
        var ent: Entity = Entity("libros",id1)
        if (ingreso>0){
            if(resta>=0){

                ent.setValue("cantidad_lib", resta.toString())
                numero=0
                ent.save()
                if (resta==0){
                    Toast.makeText(contexto,"Recuerda que haz donado todos los libros de esta categorìa", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(contexto,"No existe el nùmero de libros especificados en bodega", Toast.LENGTH_LONG).show()
                limite=1
            }
            ingreso=0
        }else{

            ent.setValue("cantidad_lib", sum.toString())
            numero=0
            ent.save()
        }


    }

    fun InsertarDonacion (agenda : Donacion,contexto: Context?){
        //DataFramework.getInstance().open(contexto, "com.example.acceso_bdd_framework")
        var ent: Entity = Entity("registro_donacion")
        ent.setValue("codigo_don", agenda.getCodigo1())
        ent.setValue("codigo_lib", agenda.getCodigo2())
        ent.setValue("cantidad_reg", agenda.getCantidad1())
        ent.setValue("fecha_reg", agenda.getFecha())
        //ent.setValue("fechasep_reg", fecha.toString())
        Toast.makeText(contexto,"Se inserto correctamente", Toast.LENGTH_SHORT).show()
        ent.save()

    }

    fun ConsultarDonacion(contexto: Context?):ArrayList<Donacion>{
        var listado=ArrayList<Donacion>()
        var donaciones1:List<Entity> = DataFramework.getInstance().getEntityList("registro_donacion")
        var iter : Iterator<Entity> = donaciones1.iterator()
        var p=Donacion()
        while (iter.hasNext()){
            var ent: Entity =iter.next()
            p= Donacion(ent.getString("codigo_don"),ent.getString("codigo_lib"),ent.getString("cantidad_reg"),ent.getString("fecha_reg"))

            listado.add(p)

        }
        return listado
    }
fun InsertarEnvioDonacion (agenda : Donacion,contexto: Context?){
        //DataFramework.getInstance().open(contexto, "com.example.acceso_bdd_framework")
        if (limite==0){
            var ent: Entity = Entity("envio_donacion")
            ent.setValue("codigo_don", agenda.getCodigo1())
            ent.setValue("codigo_lib", agenda.getCodigo2())
            ent.setValue("cantidad_env", agenda.getCantidad1())
            ent.setValue("fecha_env", agenda.getFecha())
            //ent.setValue("fechasep_env", fecha.toString())

            Toast.makeText(contexto,"Se inserto correctamente", Toast.LENGTH_SHORT).show()
            ent.save()
        }
        limite=0



    }

    fun ConsultarEnvioDonacion(contexto: Context?):ArrayList<Donacion>{
        var listado=ArrayList<Donacion>()
        var donaciones1:List<Entity> = DataFramework.getInstance().getEntityList("envio_donacion")
        var iter : Iterator<Entity> = donaciones1.iterator()
        var p=Donacion()
        while (iter.hasNext()){
            var ent: Entity =iter.next()
            p= Donacion(ent.getString("codigo_don"),ent.getString("codigo_lib"),ent.getString("cantidad_env"),ent.getString("fecha_env"))

            listado.add(p)
        }
        return listado
    }
/*fun ConsultarEnvioDonacion(contexto: Context?,fecha:String):ArrayList<Donacion>{
        var idEnvDon:Long=-1
        var listado=ArrayList<Donacion>()
        var donaciones1:List<Entity> = DataFramework.getInstance().getEntityList("envio_donacion","fechasep_env='"+fecha+"'")
        var iter : Iterator<Entity> = donaciones1.iterator()
        var p=Donacion()
        while (iter.hasNext()){
            var ent: Entity =iter.next()
            if (idEnvDon > -1){

                p= Donacion(ent.getString("codigo_don"),ent.getString("codigo_lib"),ent.getString("cantidad_env"),ent.getString("fecha_env"),ent.getString("fechasep_env"))

                listado.add(p)
            }


        }
        return listado
    }*/


/*
    fun EliminarPersona(contexto: Context?){
        var ent: Entity = Entity("tbagenda",idpersona)
        //Toast.makeText(contexto,"${idpersona}", Toast.LENGTH_SHORT).show()
        ent.delete()
        if (idpersona > -1) {
            Toast.makeText(contexto, "Registro Eliminado", Toast.LENGTH_SHORT).show()
            idpersona=-1
        }
    }
    */

}