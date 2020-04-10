package com.example.donacioneslibros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.dataframework.DataFramework
import com.example.donacioneslibros.Adaptadores.AdaptadorDonaciones
import com.example.donacioneslibros.GestionBddDonacioes.ProcesosDonaciones
import com.example.donacioneslibros.Registros.Donacion
import kotlinx.android.synthetic.main.activity_listado_donaciones.*

class ListadoDonaciones : AppCompatActivity() {
    var ListadoD=ArrayList<Donacion>()
    val pbd= ProcesosDonaciones()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_donaciones)
        DataFramework.getInstance().open(this, "com.example.donacioneslibros")
        var adpAgenda= AdaptadorDonaciones(this,pbd.ConsultarDonacion(this))
        lv_donaciones.adapter=adpAgenda
    }

}
