package com.evento.apptallerautoridad.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evento.apptallerautoridad.R
import com.evento.apptallerautoridad.model.Hotel
import com.evento.apptallerautoridad.utils.inflate
import kotlinx.android.synthetic.main.card_hotel.view.*

class AdapterHotel (var hoteles: List<Hotel>, val clickListener: (Hotel, mode: Int) -> Unit)
    : RecyclerView.Adapter<AdapterHotel.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
            Holder(parent.inflate(R.layout.card_hotel))

    override fun getItemCount(): Int =
            hoteles.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val hotel = hoteles[position]

        holder.bindView(hotel, clickListener)
    }


    class Holder (itemVIew: View): RecyclerView.ViewHolder(itemVIew) {
        fun bindView(hotel: Hotel, clickListener: (Hotel, mode: Int) -> Unit) {
            with(hotel) {

                val resource = when (id) {
                    1 -> R.drawable.casa_andina
                    2 -> R.drawable.costa_sol
                    3 -> R.drawable.sunec_hotel
                    4 -> R.drawable.solec_bussines
                    5 -> R.drawable.hotel_sipan
                    else -> R.drawable.casa_andina
                }

                itemView.card_imagen_hotel.setImageResource(resource)

                itemView.card_nombre_hotel.text = nombre
                itemView.card_direccion_hotel.text = direccion
                itemView.card_estrellas_hotel.text = estrellas
                itemView.card_phone_hotel.text = phone

                itemView.card_web_hotel.setOnClickListener {
                    clickListener(hotel, 0)
                }
                itemView.card_ubicacion_hotel.setOnClickListener {
                    clickListener(hotel, 1)
                }

                itemView.card_phone_hotel.setOnClickListener {
                    clickListener(hotel, 2)
                }
            }
        }
    }
}