package mobile.kikoololasv.fr.smartnotif

import android.app.Application
import com.facebook.FacebookSdk

class SMApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FacebookSdk.sdkInitialize(applicationContext)

        GRAPH = DaggerSmartNotifComponent.builder().smartNotifModule(SmartNotifModule((this))).build()
    }
    companion object {
        lateinit var GRAPH : SmartNotifComponent

    }
}