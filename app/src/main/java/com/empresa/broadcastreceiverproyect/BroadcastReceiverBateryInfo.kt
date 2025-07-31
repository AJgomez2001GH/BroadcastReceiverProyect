package com.empresa.broadcastreceiverproyect

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BroadcastReceiverBatteryInfo: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // Aquí defines qué pasa cuando se recibe el broadcast
        println( "¡Broadcast recibido******************************************************************!")
    }

}