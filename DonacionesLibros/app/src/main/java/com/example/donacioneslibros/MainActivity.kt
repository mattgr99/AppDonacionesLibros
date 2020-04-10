package com.example.donacioneslibros

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.donacioneslibros.fragments.*
import com.example.donacioneslibros.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
    }

    inner class SectionsPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm){
        override fun getItem(position: Int): Fragment {
            when(position){
                0 -> return fragmentInsertarDonante()
                1 -> return fragment_insertar_beneficiario()
                2 -> return fragment_listado_libros()
                3 -> return fragment_insertar_donacion()
                4 -> return fragment_insertar_envio_donacion()
                else -> return fragmentInsertarDonante()
            }
        }

        override fun getCount(): Int {
            return 5 //Porque hay 3 fragmentos
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when(position){
                0 -> return "Donante"
                1 -> return "Beneficiario"
                2 -> return "Bodega Libros"
                3 -> return "Donación"
                4 -> return "Envío Donación"

                else -> return null
            }
        }




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