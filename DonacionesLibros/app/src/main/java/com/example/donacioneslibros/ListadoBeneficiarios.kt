package com.example.donacioneslibros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.dataframework.DataFramework
import com.example.donacioneslibros.Adaptadores.AdaptadorPersona
import com.example.donacioneslibros.GestionBddDonacioes.ProcesosDonaciones
import com.example.donacioneslibros.Registros.Persona
import kotlinx.android.synthetic.main.activity_listado_beneficiarios.*

class ListadoBeneficiarios : AppCompatActivity() {
    val pbd= ProcesosDonaciones()
    var ListadoPersonas=ArrayList<Persona>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_beneficiarios)
        DataFramework.getInstance().open(this, "com.example.donacioneslibros")
        var adpAgenda=AdaptadorPersona(this,pbd.ConsultarBeneficiario(this))
        lv_beneficiarios.adapter=adpAgenda
    }

}
