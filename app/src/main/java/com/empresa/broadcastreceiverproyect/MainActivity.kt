package com.empresa.broadcastreceiverproyect

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val ACTION_MI_MENSAJE = "com.example.myapplication4.ACTION_MI_MENSAJE"
class MainActivity : AppCompatActivity() {
    // Se declara el receiver del broadcast que vas a escuchar
    private val receiverBroadcastCambioBateria = BroadcastReceiverBatteryInfo()
    private val receiverBroadcastCustomInfo1 = BroadcastReceiverCustomInfo1()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Se instancian los elementos del xml
        val btnSendBroadcast = findViewById<Button>(R.id.btnSendBroadcast)


        // Se inicializa el broadcast receiver que recibe informacion de la bateria
        // Siempre que cambie la bateria se va ejecutar la clase "BroadcastReceiverBatteryInfo"
        val filterBroadcastCambioBateria = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(receiverBroadcastCambioBateria, filterBroadcastCambioBateria)


        // Se inicializa el broadcast receiver que recibe informacion cuando se presiona el boton
        //Esto le dice al sistema: "Si se lanza un intent con la acción ACTION_MI_MENSAJE, llama a receiverBroadcastCustomInfo1".
        //Esto es un registro dinámico, válido mientras la app esté viva.
        val filterBroadcastButtonPressed = IntentFilter(ACTION_MI_MENSAJE)
        registerReceiver(
            receiverBroadcastCustomInfo1,
            filterBroadcastButtonPressed,
            RECEIVER_EXPORTED // O RECEIVER_EXPORTED si quieres aceptar mensajes de otras apps
        )


        // Mandar mensaje de broadcast con la accion "ACTION_MI_MENSAJE"
        //Aquí creas un Intent con la acción ACTION_MI_MENSAJE.
        btnSendBroadcast.setOnClickListener {
            val intent = Intent(ACTION_MI_MENSAJE)
            sendBroadcast(intent)
        }

    }
}




/*
FLUJO PARA receiverBroadcastCustomInfo1
[Usuario presiona botón]
       ↓
sendBroadcast(Intent con acción "ACTION_MI_MENSAJE")
       ↓
Sistema Android busca receivers registrados con esa acción
       ↓
Llama a onReceive() de BroadcastReceiverCustomInfo1
 */