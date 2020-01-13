package com.acrony.kotlinspinnerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countries=resources.getStringArray(R.array.countries)

        val spnCountries=findViewById<Spinner>(R.id.spCountries)

        if(spnCountries!=null)
        {
            val adapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,countries)

            spnCountries.adapter=adapter

            spnCountries.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {

                        Toast.makeText(this@MainActivity,getString(R.string.selecteditem)+""+countries[position],Toast.LENGTH_LONG).show()

                    }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@MainActivity,"Nothing Selected ",Toast.LENGTH_LONG).show()

                }

            }

        }

    }
}
