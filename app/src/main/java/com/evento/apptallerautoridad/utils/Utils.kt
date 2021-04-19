package com.evento.apptallerautoridad.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author k3ntu
 * */

fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}