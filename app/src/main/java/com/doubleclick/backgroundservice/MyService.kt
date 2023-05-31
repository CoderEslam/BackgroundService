package com.doubleclick.backgroundservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class MyService : Service() {

    private val TAG = "MyService"

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        onTaskRemoved(intent)
//        val t = Timer()
//        val tt: TimerTask = object : TimerTask() {
//            override fun run() {
                Toast.makeText(
                    applicationContext, "This is a Service running in Background",
                    Toast.LENGTH_SHORT
                ).show()
//                Log.e(TAG, "run: ")
//            }
//        }
//        t.schedule(tt, 1000, 1000)
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        // TODO: Return the communication channel to the service.
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onTaskRemoved(rootIntent: Intent) {
        val restartServiceIntent = Intent(applicationContext, this.javaClass)
        restartServiceIntent.setPackage(packageName)
        startService(restartServiceIntent)
        super.onTaskRemoved(rootIntent)
    }
}