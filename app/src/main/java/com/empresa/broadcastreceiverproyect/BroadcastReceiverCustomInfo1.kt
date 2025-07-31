package com.empresa.broadcastreceiverproyect

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BroadcastReceiverCustomInfo1 : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        println("INFO CUSTOM 1 LLAMADO CORRECTAMENTE")
    }
}
