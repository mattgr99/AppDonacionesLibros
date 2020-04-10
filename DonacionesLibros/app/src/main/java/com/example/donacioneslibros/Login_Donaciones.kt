package com.example.donacioneslibros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login__donaciones.*

class Login_Donaciones : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login__donaciones)
        bt_ingresar.setOnClickListener{
            if (et_usuario.text.toString().equals("admin")&&et_contrasenia.text.toString().equals("admin")){
                et_usuario.setText("")
                et_contrasenia.setText("")
                val intent = Intent(this,MainActivity::class.java)
                //super.finish()
                startActivity(intent)

            }else
                Toast.makeText(this,"Usuario o Contraseña incorrecto", Toast.LENGTH_SHORT).show()
        }
    }

}
