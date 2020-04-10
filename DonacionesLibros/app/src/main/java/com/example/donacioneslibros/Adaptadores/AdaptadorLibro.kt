package com.example.donacioneslibros.Adaptadores

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.donacioneslibros.R
import com.example.donacioneslibros.Registros.Libros
import kotlinx.android.synthetic.main.item_libro.view.*

class AdaptadorLibro(): BaseAdapter() {
    var listado:ArrayList<Libros>?=null
    var miContexto: Context?=null

    constructor(contexto: Context, listaP:ArrayList<Libros>):this(){
        this.listado=listaP
        this.miContexto=contexto
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View = View.inflate(miContexto, R.layout.item_libro,null)
        view.tv_item_libro_codigo.text=listado!!.get(position).getCodigo().toString()
        view.tv_item_libro_categoria.text=listado!!.get(position).getCategoria().toString()
        view.tv_item_libro_disponible.text=listado!!.get(position).getCantidad().toString()


        return view


    }

    override fun getItem(position: Int): Libros {
        return listado!!.get(position)//devuelve el objeto por cada posicion
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {//contar cuantos item tienen el array list
        return listado!!.size
    }
}