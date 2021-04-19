package com.evento.apptallerautoridad.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import com.evento.apptallerautoridad.R

class MapaActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    var title: String = ""
    var latitud: Double = 0.0
    var longitud: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)

        val bundle = intent.extras

        bundle?.let {
            val action = it.getString("action")

            val titleToolbar = when (action) {
                "HotelMap" -> "Hotel"
                "LugarMap" -> "Lugar Turístico"
                "Mapa" -> "Mapa"
                else -> ""
            }

            title = it.getString("nombre", "")
            latitud = it.getDouble("latitud")
            longitud = it.getDouble("longitud")

            showToolbar(titleToolbar, true)
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(latitud, longitud)
        mMap.addMarker(MarkerOptions().position(sydney).title(title))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15.0f))
    }

    private fun showToolbar(title: String, upHome: Boolean = false) {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        val let = this as AppCompatActivity?

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(upHome)
        supportActionBar?.title = title
    }
}
