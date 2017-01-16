package mobile.kikoololasv.fr.smartnotif

import android.app.AlarmManager
import android.app.Application
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import mobile.kikoololasv.fr.smartnotif.trigger.DateTriggerBroadcastReceiver
import java.util.*

class SMApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        com.facebook.FacebookSdk.sdkInitialize(applicationContext)

        GRAPH = DaggerSmartNotifComponent.builder().smartNotifModule(SmartNotifModule((this))).build()

        var alarmMgr = applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        var intent = Intent(applicationContext, DateTriggerBroadcastReceiver::class.java)


        var alarmIntent = PendingIntent.getBroadcast(applicationContext, 0, intent, 0)

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        calendar.set(Calendar.HOUR_OF_DAY, 13)
        calendar.set(Calendar.MINUTE, 49)


        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                1000 * 30, alarmIntent)
    }

    companion object {
        lateinit var GRAPH: SmartNotifComponent

    }
}