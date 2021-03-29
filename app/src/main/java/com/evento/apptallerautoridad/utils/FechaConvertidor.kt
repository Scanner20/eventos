package com.evento.apptallerautoridad.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

class FechaConvertidor {

    val meses = arrayOf("Enero", "Febrero", "Marzo", "Abril", "Mayo",
            "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")

    private var simple = SimpleDateFormat("dd/MM/yyyy HH:mm")

    private var calendar = Calendar.getInstance()

    fun getMesByDate(timestamp: Timestamp): String {
        calendar.timeInMillis = timestamp.time
        return meses[calendar.get(Calendar.MONTH)]
    }

    fun parsearFecha(timestamp: Timestamp): String {
        calendar.timeInMillis = timestamp.time

        val fecha = "${calendar.get(Calendar.DAY_OF_MONTH)} de ${getMesByDate(timestamp)} del ${calendar.get(Calendar.YEAR)}"

        val hora = SimpleDateFormat("HH:mm").format(Date(calendar.timeInMillis))

        return "$fecha - $hora hrs"
    }


    fun stringToDate(date: String): Timestamp {
        return Timestamp(simple.parse(date).time)
    }

    fun dateToString(date: Timestamp): String {
        return simple.format(date)
    }

}