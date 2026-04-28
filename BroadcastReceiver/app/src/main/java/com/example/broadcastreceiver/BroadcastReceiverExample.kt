package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadcastReceiverExample : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val isAirPlaneMode : Boolean= intent!!.getBooleanExtra("state",false)

        if(isAirPlaneMode){
            var i:Int=0

            while(i<50){
                i++
                Toast.makeText(context,"The device is in airplane mode",Toast.LENGTH_LONG).show()

            }
        }else{
            var i:Int=0
            while(i<50){
                i++
                Toast.makeText(context,"The device is not in airplane mode",Toast.LENGTH_LONG).show()

            }
        }
    }
}