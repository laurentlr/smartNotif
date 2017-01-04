package mobile.kikoololasv.fr.smartnotif

import android.app.Application

class SMApplication : Application() {

    override fun onCreate() {
        super.onCreate()
       // GRAPH =
    }
    companion object {
        lateinit var GRAPH : SmartNotifComponent

    }
}