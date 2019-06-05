package com.example.baylor_list

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_details.*
import kotlinx.android.synthetic.main.content_details.detail_name
import kotlinx.android.synthetic.main.content_details.emailtxt
import kotlinx.android.synthetic.main.content_details.*

class detail : AppCompatActivity() {

         var _Lat = ""
         var _lng = ""
        lateinit var _name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)


           detail_name.text = intent.getStringExtra("Name")
            emailtxt.text =intent.getStringExtra("Email")
            txtStreet.text =intent.getStringExtra("Street")
            txtSuite.text = intent.getStringExtra("Suite")
            txtWebsite.text = intent.getStringExtra("Website")
            txtUsername.text = intent.getStringExtra("Username")
            txtZip.text = intent.getStringExtra("Zip")
            txtCity.text = intent.getStringExtra("City")
            txtCompany.text = intent.getStringExtra("Company")
            _Lat = intent.getStringExtra("Lat")
            _lng = intent.getStringExtra("Lng")
            _name = intent.getStringExtra("Name")

        fab.setOnClickListener { view ->

            val intent = Intent(applicationContext,UserMap::class.java)
            intent.putExtra("Lat",_Lat)
            intent.putExtra("Lng",_lng )
            intent.putExtra("Name", _name)
            applicationContext.startActivity(intent)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
