package com.evento.apptallerautoridad.view

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.navigation.ActivityNavigator
import androidx.recyclerview.widget.LinearLayoutManager

import com.evento.apptallerautoridad.R
import com.evento.apptallerautoridad.adapter.AdapterHotel
import com.evento.apptallerautoridad.data.entity.Hotel
import com.evento.apptallerautoridad.viewmodels.HotelViewModel
import com.google.gson.Gson
import kikopalomares.com.apicallsretrofit.data.remote.ApiService
import kikopalomares.com.apicallsretrofit.data.remote.response.HotelResponse
import kotlinx.android.synthetic.main.hotel_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HotelFragment : Fragment() {

    companion object {
        fun newInstance() = HotelFragment()
    }

    private val lista = arrayListOf<Hotel>()

    private lateinit var viewModel: HotelViewModel

    private lateinit var adapter: AdapterHotel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.hotel_fragment, container, false)

        showToolbar(view, "Hoteles")
        setHasOptionsMenu(true)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HotelViewModel::class.java)

        activity?.let {

            adapter = AdapterHotel(lista) { hotel, mode -> hotelItemClicked(hotel, mode) }

            rcViewHotel.apply {
                layoutManager = LinearLayoutManager(it)
                adapter = this@HotelFragment.adapter
            }

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val activity = activity as AppCompatActivity?
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    val TAG_LOGS = "kikopalomares"

    lateinit var service: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.1.4:9001/hotel/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create<ApiService>(ApiService::class.java)

        getAllHotel()
        //  getPostById()
        //   editPost()
    }
    fun getAllHotel() {

        //Recibimos todos los posts

        service.getAllHotel("1").enqueue(object : Callback<HotelResponse> {
            override fun onResponse(call: Call<HotelResponse>?, response: Response<HotelResponse>?) {
                val posts = response?.body()
                Log.i("CODIGO RESPUESTA: ", posts?.codigoRespuesta)
                Log.i("mensajeRespuesta: ", posts?.mensajeRespuesta)
                Log.i(TAG_LOGS, Gson().toJson(posts))
                posts?.parametros?.codigoCatalogo?.forEach {
                    var hotel = Hotel(it.id!!.toInt(), it.nombre!!,it.direccion!!,it.estrellas!!,it.phone!!,it.web!!,it.latitud!!,it.longitud!!)
                    lista.add(hotel)

                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<HotelResponse>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

    private fun llenarHotel() {
        getAllHotel()
        lista.clear()


    }

    // Methods
    private fun hotelItemClicked(hotel: Hotel, mode: Int) {
        activity?.let {
            if (mode == 0) {
                val i = Intent(Intent.ACTION_VIEW, Uri.parse(hotel.web))
                startActivity(i)
            } else if (mode == 1) {
                val bundle = bundleOf("action" to "HotelMap",
                        "nombre" to hotel.nombre,
                        "latitud" to hotel.latitud,
                        "longitud" to hotel.longitud)

                ActivityNavigator(it)
                        .createDestination()
                        .setIntent(Intent(it, MapaActivity::class.java))
                        .navigate(bundle, null, null)
            } else if (mode == 2) {
                val i = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", hotel.phone, null))
                startActivity(i)
            }
        }
    }

    private fun showToolbar(view: View, title: String = "") {
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)

        val let = activity as AppCompatActivity?
        let?.let {
            let.setSupportActionBar(toolbar)
            let.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            let.supportActionBar?.title = title
        }
    }
}
