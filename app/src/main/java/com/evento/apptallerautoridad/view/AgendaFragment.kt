package com.evento.apptallerautoridad.view
import android.util.Log
import android.os.Build
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
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager
import kikopalomares.com.apicallsretrofit.data.remote.entity.ParametrosAgendaEntity
import com.evento.apptallerautoridad.R
import com.evento.apptallerautoridad.adapter.AdapterAgenda
import com.evento.apptallerautoridad.data.entity.Agenda
import com.evento.apptallerautoridad.utils.FechaConvertidor
import com.evento.apptallerautoridad.viewmodels.AgendaViewModel
import com.google.gson.Gson
import kikopalomares.com.apicallsretrofit.data.remote.ApiService
import kikopalomares.com.apicallsretrofit.data.remote.response.AgendaResponse
import kotlinx.android.synthetic.main.agenda_fragment.*
import java.sql.Timestamp
import java.text.SimpleDateFormat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AgendaFragment : Fragment() {

    companion object {
        fun newInstance() = AgendaFragment()
    }

    val lista = arrayListOf<Agenda>()

    private lateinit var viewModel: AgendaViewModel

    private lateinit var adapter: AdapterAgenda

    var options: NavOptions? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.agenda_fragment, container, false)

        showToolbar(view, "agenda")
        setHasOptionsMenu(true)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AgendaViewModel::class.java)

        val toolbar = activity?.findViewById<Toolbar>(R.id.collapsing_toolbar_agenda)
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


            adapter = AdapterAgenda(lista) { eventoItem: Agenda -> eventoItemClicked(eventoItem) }

            rcViewAgenda.apply {
                layoutManager = LinearLayoutManager(it)
                adapter = this@AgendaFragment.adapter
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
                .baseUrl("http://192.168.1.10:9001/agenda/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create<ApiService>(ApiService::class.java)

        getAllAgenda()
        //  getPostById()
        //   editPost()
    }
    fun getAllAgenda() {

        //Recibimos todos los posts

        service.getAllAgenda("1").enqueue(object : Callback<AgendaResponse> {
            override fun onResponse(call: Call<AgendaResponse>?, response: Response<AgendaResponse>?) {
                val posts = response?.body()
                Log.i("CODIGO RESPUESTA: ", posts?.codigoRespuesta)
                Log.i("mensajeRespuesta: ", posts?.mensajeRespuesta)
                 Log.i(TAG_LOGS, Gson().toJson(posts))
                val date = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")


                posts?.parametros?.codigoCatalogo?.forEach {
                    var agenda = Agenda(it.id_agenda!!.toInt(), it.tema!!,it.fecha!!,it.nombre!!,it.apellido!!)
                    lista.add(agenda)

                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<AgendaResponse>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

    private fun llenarAgenda() {
        lista.clear()
        getAllAgenda()


    }

    private fun eventoItemClicked(evento: Agenda) {
        val format = FechaConvertidor().dateToString(evento.fecha)

        context?.let {
            val bundle = bundleOf("id" to evento.id,
                    "tema" to evento.tema,
                    "fecha" to format,
                    "nombre" to evento.nombre,
                    "apellido" to evento.apellido)

            findNavController().navigate(R.id.detalleAgendaFragment, bundle, options)
        }
    }

    private fun showToolbar(view: View, title: String = "") {
        val toolbar = view.findViewById<Toolbar>(R.id.collapsing_toolbar_agenda)

        val let = activity as AppCompatActivity?
        let?.let {
            let.setSupportActionBar(toolbar)
            let.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            let.supportActionBar?.title = title
        }
    }

}
