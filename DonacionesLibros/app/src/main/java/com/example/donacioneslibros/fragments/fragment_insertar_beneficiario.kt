package com.example.donacioneslibros.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.dataframework.DataFramework
import com.example.donacioneslibros.GestionBddDonacioes.ProcesosDonaciones
import com.example.donacioneslibros.ListadoBeneficiarios
import com.example.donacioneslibros.R
import com.example.donacioneslibros.Registros.Persona
import kotlinx.android.synthetic.main.activity_fragment_insertar_beneficiario.view.*

class fragment_insertar_beneficiario : Fragment() {
    var idpersona:Long=-1
    val pbd=ProcesosDonaciones()
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.activity_fragment_insertar_beneficiario, container,false)
        DataFramework.getInstance().open(context, "com.example.donacioneslibros")
        view.bt_registrar_beneficiario.setOnClickListener{
            if (view.et_cedula_beneficiario.text.toString().equals("")||view.et_nombre_beneficiario.text.toString().equals("")||view.et__telefono_beneficiario.text.toString().equals("")||view.et_direccion_beneficiario.text.toString().equals("")){
                Toast.makeText(context,"Llena todos los campos", Toast.LENGTH_SHORT).show()
            }else{

                idpersona=pbd.ConsultarBeneficiario(view.et_cedula_beneficiario.text.toString())
                if (idpersona>-1){
                    Toast.makeText(context,"El beneficiario ya se encuentra registrado", Toast.LENGTH_SHORT).show()
                }else{
                    var objBd1=Persona(view.et_cedula_beneficiario.text.toString(),view.et_nombre_beneficiario.text.toString(),view.et__telefono_beneficiario.text.toString(),view.et_direccion_beneficiario.text.toString())
                    pbd.InsertarBeneficiario(objBd1,context)
                }

                view.et_cedula_beneficiario.setText("")
                view.et_nombre_beneficiario.setText("")
                view.et__telefono_beneficiario.setText("")
                view.et_direccion_beneficiario.setText("")
            }


        }
        view.bt_listar_beneficiario.setOnClickListener{
            val intent = Intent(context,ListadoBeneficiarios::class.java)
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

