package com.evento.apptallerautoridad.view

import android.content.Intent
import android.os.Build
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions

import com.evento.apptallerautoridad.R
import com.evento.apptallerautoridad.viewmodels.InformacionViewModel
import kotlinx.android.synthetic.main.informacion_fragment.*

class InformacionFragment : Fragment() {

    companion object {
        fun newInstance() = InformacionFragment()
    }

    private lateinit var viewModel: InformacionViewModel

    private var options: NavOptions? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.informacion_fragment, container, false)

        showToolbar(view, "Información")
        setHasOptionsMenu(true)

        return view
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InformacionViewModel::class.java)

        activity?.let {il ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                options = navOptions {
                    anim {
                        enter = R.anim.slide_in_right
                        exit = R.anim.slide_out_left
                        popEnter = R.anim.slide_in_left
                        popExit = R.anim.slide_out_right
                    }
                }
            }

            btn_mapa.setOnClickListener {
                val bundle = bundleOf("action" to "Mapa",
                        "nombre" to "Chiclayo",
                        "latitud" to -6.7716629446072005,
                        "longitud" to -79.83869809877605)

                ActivityNavigator(il)
                        .createDestination()
                        .setIntent(Intent(il, MapaActivity::class.java))
                        .navigate(bundle, options, null)
            }

            btn_lugar_turistico.setOnClickListener {
                findNavController().navigate(R.id.lugarTuristicoFragment, null, options)
            }

            btn_hoteles.setOnClickListener {
                findNavController().navigate(R.id.hotelFragment, null, options)
            }

            btn_recomendaciones.setOnClickListener {
                val layoutInflater = LayoutInflater.from(il)
                val view: View = layoutInflater.inflate(R.layout.dialog_recomendaciones, null)

                val alertDialog = AlertDialog.Builder(il)
                alertDialog.setView(view)

                alertDialog.setCancelable(false)
                        .setPositiveButton("Salir") { dialog, _ ->
                            dialog.cancel()
                        }

                val alert = alertDialog.create()

                alert.show()
            }

        }
    }

    private fun showToolbar(view: View, title: String) {
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)

        val let = activity as AppCompatActivity?
        let?.let {
            let.setSupportActionBar(toolbar)
            let.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            let.supportActionBar?.title = title
        }
    }

}
