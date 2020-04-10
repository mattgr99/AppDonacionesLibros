package com.example.donacioneslibros.Adaptadores

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.donacioneslibros.R
import com.example.donacioneslibros.Registros.Donacion
import kotlinx.android.synthetic.main.item_donaciones.view.*

class AdaptadorDonaciones(): BaseAdapter() {
    var listado:ArrayList<Donacion>?=null
    var miContexto: Context?=null

    constructor(contexto: Context, listaP:ArrayList<Donacion>):this(){
        this.listado=listaP
        this.miContexto=contexto
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View = View.inflate(miContexto, R.layout.item_donaciones,null)
        view.tv_item_donaciones_cedula.text=listado!!.get(position).getCodigo1().toString()
        view.tv_item_donaciones_codigo.text=listado!!.get(position).getCodigo2().toString()
        view.tv_item_donaciones_cantidad.text=listado!!.get(position).getCantidad1().toString()
        view.tv_item_donaciones_fecha.text=listado!!.get(position).getFecha().toString()

        return view


    }

    override fun getItem(position: Int): Donacion {
        return listado!!.get(position)//devuelve el objeto por cada posicion
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {//contar cuantos item tienen el array list
        return listado!!.size
    }
}