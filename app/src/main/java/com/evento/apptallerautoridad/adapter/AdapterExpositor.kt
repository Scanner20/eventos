package com.evento.apptallerautoridad.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evento.apptallerautoridad.data.entity.Expositor
import com.evento.apptallerautoridad.R
import com.evento.apptallerautoridad.utils.inflate
import kotlinx.android.synthetic.main.card_expositor.view.*

class AdapterExpositor (var expositores: List<Expositor>, val clickListener: (Expositor) -> Unit)
    : RecyclerView.Adapter<AdapterExpositor.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
            Holder(parent.inflate(R.layout.card_expositor))

    override fun getItemCount(): Int = expositores.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val expositor = expositores[position]

        holder.bindView(expositor, clickListener)
    }

    class Holder (itemVIew: View): RecyclerView.ViewHolder(itemVIew) {
        fun bindView(expositor: Expositor, clickListener: (Expositor) -> Unit) {
            with(expositor) {
                itemView.expositor_nombre.text = "$nombre $apellido"

                itemView.expositor_cargo.text = cargo

                val drawable = when (id) {
                    1 -> R.drawable.guillermo
                    2 -> R.drawable.luis
                    3 -> R.drawable.rene
                    4 -> R.drawable.menotti

                    else -> R.drawable.ic_user_default
                }

                itemView.expositor_imagen.setImageResource(drawable)

                itemView.setOnClickListener {
                    clickListener(expositor)
                }
            }
        }
    }
}