package com.example.donacioneslibros.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.dataframework.DataFramework
import com.example.donacioneslibros.Adaptadores.AdaptadorLibro
import com.example.donacioneslibros.GestionBddDonacioes.ProcesosDonaciones
import com.example.donacioneslibros.R
import com.example.donacioneslibros.RegistroLibros
import com.example.donacioneslibros.Registros.Libros
import kotlinx.android.synthetic.main.activity_fragment_listado_libros.view.*

class fragment_listado_libros : Fragment() {
    val pbd= ProcesosDonaciones()
    var ListadoLibros=ArrayList<Libros>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.activity_fragment_listado_libros, container,false)
        DataFramework.getInstance().open(context, "com.example.donacioneslibros")
        var adpAgenda= AdaptadorLibro(context!!,pbd.ConsultarLibro(context))
        view.lv_libros.adapter=adpAgenda

        view.bt_registrar_libro.setOnClickListener{
            val intent = Intent(context,RegistroLibros::class.java)
            //super.finish()
            startActivity(intent)
        }


        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        DataFramework.getInstance().close()
    }
}
