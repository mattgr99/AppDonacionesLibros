package com.example.donacioneslibros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.dataframework.DataFramework
import com.example.donacioneslibros.Adaptadores.AdaptadorEnvioDonacion
import com.example.donacioneslibros.GestionBddDonacioes.ProcesosDonaciones
import com.example.donacioneslibros.Registros.Donacion
import kotlinx.android.synthetic.main.activity_listado_envio_donacion.*

class ListadoEnvioDonacion : AppCompatActivity() {
    var ListadoD=ArrayList<Donacion>()
    val pbd= ProcesosDonaciones()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_envio_donacion)
        DataFramework.getInstance().open(this, "com.example.donacioneslibros")
        var adpAgenda= AdaptadorEnvioDonacion(this,pbd.ConsultarEnvioDonacion(this))
        lv_envio_donacion.adapter=adpAgenda

    }
}
