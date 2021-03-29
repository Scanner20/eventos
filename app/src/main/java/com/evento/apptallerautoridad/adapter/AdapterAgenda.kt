package com.evento.apptallerautoridad.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evento.apptallerautoridad.model.Agenda
import com.evento.apptallerautoridad.R
import com.evento.apptallerautoridad.utils.FechaConvertidor
import com.evento.apptallerautoridad.utils.inflate
import kotlinx.android.synthetic.main.card_agenda.view.*
import java.util.*

class AdapterAgenda (var agendas: List<Agenda>, val clickListener: (Agenda) -> Unit)
    : RecyclerView.Adapter<AdapterAgenda.Holder>() {

    private var calendar = Calendar.getInstance()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
            Holder(parent.inflate(R.layout.card_agenda))

    override fun getItemCount(): Int = agendas.size


    override fun onBindViewHolder(holder: Holder, position: Int) {
        val agenda = agendas[position]

        var cabecera = false
        if (position == 0){
            cabecera = true
        } else {
            if (position > 0) {
                calendar.timeInMillis = agendas[position - 1].fecha.time
                val mes1 = calendar.get(Calendar.MONTH)

                calendar.timeInMillis = agenda.fecha.time
                val mes2 = calendar.get(Calendar.MONTH)

                if (mes1 < mes2)
                    cabecera = true
            }
        }

        holder.bindView(agenda, cabecera, clickListener)
    }


    class Holder (itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindView(agenda: Agenda, cabecera: Boolean, clickListener: (Agenda) -> Unit) {
            with(agenda) {
                val convertidor = FechaConvertidor()

                if (cabecera) {
                    itemView.agenda_separador.visibility = View.VISIBLE
                    itemView.agenda_titulo_cabecera.visibility = View.VISIBLE

                    itemView.agenda_titulo_cabecera.text = convertidor.getMesByDate(fecha)
                } else {
                    if (itemView.agenda_separador.visibility == View.VISIBLE || itemView.agenda_titulo_cabecera.visibility == View.VISIBLE) {
                        itemView.agenda_separador.visibility = View.GONE
                        itemView.agenda_titulo_cabecera.visibility = View.GONE
                    }
                }

                itemView.agenda_tema.text = tema

                itemView.agenda_fecha.text = convertidor.parsearFecha(fecha)

                itemView.setOnClickListener {
                    clickListener(agenda)
                }
            }
        }
    }
}