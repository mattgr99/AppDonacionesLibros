package com.example.donacioneslibros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.dataframework.DataFramework
import com.example.donacioneslibros.GestionBddDonacioes.ProcesosDonaciones
import com.example.donacioneslibros.Registros.Libros
import kotlinx.android.synthetic.main.activity_registro_libros.*

class RegistroLibros : AppCompatActivity() {
    var idlibro:Long=-1
    val pbd= ProcesosDonaciones()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_libros)
        DataFramework.getInstance().open(this, "com.example.donacioneslibros")
        bt_registro_registrar_libro.setOnClickListener{
            if (et_codigo_libro.text.toString().equals("")||et_categoria_libro.text.toString().equals("")){
                Toast.makeText(this,"Llena todos los campos", Toast.LENGTH_SHORT).show()
            }else{

                idlibro=pbd.ConsultarLibro(et_codigo_libro.text.toString())
                if (idlibro>-1){
                    Toast.makeText(this,"El libro ya se encuentra registrado", Toast.LENGTH_SHORT).show()
                }else{
                    var objBd1=Libros(et_codigo_libro.text.toString(),et_categoria_libro.text.toString(),tv_disponibles_libro.text.toString())
                    pbd.InsertarLibro(objBd1,this)
                }

                et_codigo_libro.setText("")
                et_categoria_libro.setText("")
            }

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        DataFramework.getInstance().close()
    }

    override fun onBackPressed(){
        //val intent = Intent(this,MainActivity::class.java)
        //
        // onDestroy()
        System.exit(0)
        //startActivity(intent)
        // super.finish()
    }
}
