package com.example.donacioneslibros.Adaptadores

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.donacioneslibros.R
import com.example.donacioneslibros.Registros.Persona
import kotlinx.android.synthetic.main.item_persona.view.*

class AdaptadorPersona(): BaseAdapter() {
    var listado:ArrayList<Persona>?=null
    var miContexto: Context?=null

    constructor(contexto: Context, listaP:ArrayList<Persona>):this(){
        this.listado=listaP
        this.miContexto=contexto
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View = View.inflate(miContexto, R.layout.item_persona,null)
        view.tv_persona_cedula.text=listado!!.get(position).getCedula().toString()
        view.tv_persona_nombre.text=listado!!.get(position).getNombre().toString()
        view.tv_persona_telefono.text=listado!!.get(position).getTelefono().toString()
        view.tv_persona_direccion.text=listado!!.get(position).getDireccion().toString()


        return view


    }

    override fun getItem(position: Int): Persona {
        return listado!!.get(position)//devuelve el objeto por cada posicion
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {//contar cuantos item tienen el array list
        return listado!!.size
    }
}