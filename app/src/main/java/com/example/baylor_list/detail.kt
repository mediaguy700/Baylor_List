package com.example.baylor_list

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_details.*
import kotlinx.android.synthetic.main.content_details.detail_name
import kotlinx.android.synthetic.main.content_details.emailtxt
import kotlinx.android.synthetic.main.content_details.*

class detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)


            detail_name.text = intent.getStringExtra("Name")
            emailtxt.text =intent.getStringExtra("Email")
            txtStreet.text =intent.getStringExtra("Street")
            txtSuite.text = intent.getStringExtra("Suite")
            //xt_website.text = intent.getStringExtra("Website")
            //txt_username.text = intent.getStringExtra("Username")

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
