package com.evento.apptallerautoridad.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evento.apptallerautoridad.R
import com.evento.apptallerautoridad.model.LugarTuristico
import com.evento.apptallerautoridad.utils.inflate
import kotlinx.android.synthetic.main.card_lugar_turistico.view.*

class AdapterLugarTuristico (var lista: List<LugarTuristico>, var clickListener: (LugarTuristico) -> Unit)
    : RecyclerView.Adapter<AdapterLugarTuristico.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
            Holder(parent.inflate(R.layout.card_lugar_turistico))

    override fun getItemCount(): Int = lista.size


    override fun onBindViewHolder(holder: Holder, position: Int) {
        val lugarTuristico = lista[position]

        holder.bindView(lugarTuristico, clickListener)
    }

    class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindView(lugarTuristico: LugarTuristico, clickListener: (LugarTuristico) -> Unit) {
            with(lugarTuristico) {

                val resource = when (id) {
                    1 -> R.drawable.huaca_rajada
                    2 -> R.drawable.reserva_ecologica_chaparri
                    3 -> R.drawable.santuario_pomac
                    4 -> R.drawable.museo_sican
                    5 -> R.drawable.tumbas_reales_sipan
                    6 -> R.drawable.museo_brunning
                    7 -> R.drawable.mercado_monsefu
                    8 -> R.drawable.catedral_chiclayo
                    9 -> R.drawable.palacio_municipal_chiclayo
                    10 -> R.drawable.balneario_pimentel
                    11 -> R.drawable.ciudad_ferrenafe
                    12 -> R.drawable.ciudad_lambayeque
                    else -> R.drawable.santuario_pomac
                }

                itemView.card_lugar_imagen.setImageResource(resource)

                itemView.card_lugar_nombre.text = nombre
                itemView.card_lugar_resenia.text = resenia

                itemView.card_lugar_ubicacion.setOnClickListener {
                    clickListener(lugarTuristico)
                }
            }
        }
    }
}