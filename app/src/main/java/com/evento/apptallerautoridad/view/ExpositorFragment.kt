package com.evento.apptallerautoridad.view

import android.os.Build
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
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager

import com.evento.apptallerautoridad.R
import com.evento.apptallerautoridad.adapter.AdapterExpositor
import com.evento.apptallerautoridad.data.entity.Expositor
import com.evento.apptallerautoridad.viewmodels.ExpositorViewModel
import kikopalomares.com.apicallsretrofit.data.remote.ApiService
import kikopalomares.com.apicallsretrofit.data.remote.response.ExpositoresResponse
import kotlinx.android.synthetic.main.expositor_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ExpositorFragment : Fragment() {


    companion object {
        fun newInstance() = ExpositorFragment()
    }


    private val lista = arrayListOf<Expositor>()
    private lateinit var adapter: AdapterExpositor

    private lateinit var viewModel: ExpositorViewModel

    var options: NavOptions? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //aca ya estas inflando la vista
        val view = inflater.inflate(R.layout.expositor_fragment, container, false)

        showToolbar(view, "Expositores")
        setHasOptionsMenu(true)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ExpositorViewModel::class.java)

        val toolbar = activity?.findViewById<Toolbar>(R.id.collapsing_toolbar_expositores)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        activity?.let {
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

            adapter = AdapterExpositor(lista) { expositorItem: Expositor -> eventoItemClicked(expositorItem) }

            rcViewExpositores.apply {
                layoutManager = LinearLayoutManager(it)
                adapter = this@ExpositorFragment.adapter
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



    lateinit var service: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.1.10:9001/expositor/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create<ApiService>(ApiService::class.java)

        getAllPosts()
        //  getPostById()
        //   editPost()
    }

    fun getAllPosts() {

        //Recibimos todos los posts

        service.getAllPosts("1").enqueue(object : Callback<ExpositoresResponse> {
            override fun onResponse(call: Call<ExpositoresResponse>?, response: Response<ExpositoresResponse>?) {
                val posts = response?.body()
                Log.i("CODIGO RESPUESTA: ", posts?.codigoRespuesta)
                Log.i("mensajeRespuesta: ", posts?.mensajeRespuesta)
                // Log.i(TAG_LOGS, Gson().toJson(posts))

                posts?.parametros?.codigoCatalogo?.forEach {
                    var expositor = Expositor(it.idExpositor!!.toInt(), it.nombre!!,it.apellido!!+
                            "\n",
                            it.cargo!!,it.empresa!!,it.resenia!!,it.tema!!+"")
                    lista.add(expositor)

                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ExpositoresResponse>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

    private fun llenarExpositores() {
        getAllPosts()
        lista.clear()

    }

    private fun eventoItemClicked(expositor: Expositor) {
        val bundle = bundleOf("id" to expositor.id,
                "nombre" to expositor.nombre,
                "apellido" to expositor.apellido,
                "cargo" to expositor.cargo,
                "empresa" to expositor.empresa,
                "resenia" to expositor.resenia,
                "tema" to expositor.tema
        )

        findNavController().navigate(R.id.detalleExpositorFragment, bundle, options)
    }

    private fun showToolbar(view: View, title: String) {
        val toolbar = view.findViewById<Toolbar>(R.id.collapsing_toolbar_expositores)

        val let = activity as AppCompatActivity?
        let?.let {
            let.setSupportActionBar(toolbar)
            let.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            let.supportActionBar?.title = title
        }
    }
}
