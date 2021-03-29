package com.evento.apptallerautoridad.view

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
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
import com.evento.apptallerautoridad.model.Hotel
import com.evento.apptallerautoridad.viewmodels.HotelViewModel
import kotlinx.android.synthetic.main.hotel_fragment.*

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

            llenarHotel()
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

    fun llenarHotel() {
        lista.clear()

        lista.add(Hotel(1, "Casa Andina Select Chiclayo",
                "Federico Villarreal 115, Chiclayo 14009", "4 Estrellas",
                "(074) 234-911", "https://www.casa-andina.com/destinos/chiclayo",
                -6.77168, -79.846274))

        lista.add(Hotel(2, "Costa del Sol Chiclayo",
                "Av. Balta 399, Chiclayo 14001", "4 Estrellas",
                "(074) 227-272", "http://www.costadelsolperu.com/chiclayo",
                -6.774347, -79.8409877))

        lista.add(Hotel(3, "Sunec Hotel",
                "Calle Manuel María Izaga 472, Chiclayo 14001", "4 Estrellas",
                "(074) 205-110", "https://www.sunechotel.com.pe",
                -6.7732444, -79.8423869))

        lista.add(Hotel(4, "Solec Business Hotel",
                "129, Zafiros, Chiclayo 14009", "3 Estrellas",
                "(074) 475-321", "https://www.hotelsolec.com",
                -6.77329, -79.840208))

        lista.add(Hotel(5, "Hotel Gran Sipán",
                "Av Luis Gonzáles Av. Luis Gonzáles Nº 1185, Chiclayo 14001", "3 Estrellas",
                "(074) 222-741", "https://www.sunechotel.com.pe",
                -6.768567,-79.842025))

        adapter.notifyDataSetChanged()
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
