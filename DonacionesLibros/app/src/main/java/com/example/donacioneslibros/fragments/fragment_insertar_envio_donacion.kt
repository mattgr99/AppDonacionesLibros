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
import com.example.donacioneslibros.ListadoEnvioDonacion
import com.example.donacioneslibros.R
import com.example.donacioneslibros.Registros.Donacion
import com.example.donacioneslibros.Registros.Persona
import kotlinx.android.synthetic.main.activity_fragment_insertar_envio_donacion.view.*
import java.text.SimpleDateFormat
import java.util.*

class fragment_insertar_envio_donacion : Fragment() {
    val fechaactual: String = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
    //val fechas: String = SimpleDateFormat("MM/yyyy", Locale.getDefault()).format(Date())

    var idpersona:Long=-1
    var idlibro:Long=-1
    var ci:String=""
    val pbd= ProcesosDonaciones()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.activity_fragment_insertar_envio_donacion, container,false)
        DataFramework.getInstance().open(context, "com.example.donacioneslibros")
        view.tv_fecha_entrega.text=fechaactual
        view.bt_buscar_Beneficiario.setOnClickListener{
            idpersona=pbd.ConsultarBeneficiario(view.et_cedula_beneficiario1.text.toString())
            var persona1= Persona()
            if (idpersona>-1){
                persona1=pbd.ConsultarBeneficiario(context,view.et_cedula_beneficiario1.text.toString())
                view.tv_nombre_beneficiario.text=persona1.getNombre().toString()
                view.tv_telefono_Beneficiario.text=persona1.getTelefono().toString()
                ci=view.et_cedula_beneficiario1.text.toString()
                view.et_cedula_beneficiario1.setText("")

            }else{
                Toast.makeText(context,"El beneficiario no se encuentra registrado", Toast.LENGTH_SHORT).show()
            }
        }

        view.bt_registrar_envio.setOnClickListener{
            if (view.tv_nombre_beneficiario.text.toString().equals("")||view.et_codigo_libro_beneficiario.text.toString().equals("")||view.et_libros_entrega.text.toString().equals("")){
                Toast.makeText(context,"Llena todos los campos", Toast.LENGTH_SHORT).show()
            }else{

                idlibro=pbd.ConsultarLibro(view.et_codigo_libro_beneficiario.text.toString())
                if (idlibro>-1){
                    pbd.ActualizarLibro(context,idlibro,view.et_libros_entrega.text.toString())
                    var objBd1= Donacion(ci,view.et_codigo_libro_beneficiario.text.toString(),view.et_libros_entrega.text.toString(),view.tv_fecha_entrega.text.toString())
                    pbd.InsertarEnvioDonacion(objBd1,context)
                    view.tv_nombre_beneficiario.text=""
                    view.tv_telefono_Beneficiario.text=""
                    view.et_codigo_libro_beneficiario.setText("")
                    view.et_libros_entrega.setText("")

                }else{
                    Toast.makeText(context,"El libro no se encuentra registrado", Toast.LENGTH_SHORT).show()
                }


            }


        }
        view.bt_beneficiados_listado.setOnClickListener{
            val intent = Intent(context,ListadoEnvioDonacion::class.java)
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
