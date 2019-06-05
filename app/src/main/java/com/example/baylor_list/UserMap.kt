package com.example.baylor_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class UserMap : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_map)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        var _Lat = intent.getStringExtra("Lat").toDouble()
        var _lng = intent.getStringExtra("Lng").toDouble()
        var _title = intent.getStringExtra("Name")
        val userpos = LatLng(_Lat, _lng)
        mMap.addMarker(MarkerOptions().position(userpos).title(intent.getStringExtra("Name")))

        mMap.moveCamera(CameraUpdateFactory.newLatLng(userpos))

    }
}
