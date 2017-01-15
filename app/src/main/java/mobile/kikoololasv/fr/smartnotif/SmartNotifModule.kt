package mobile.kikoololasv.fr.smartnotif

import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.support.v7.app.NotificationCompat
import dagger.Module
import dagger.Provides
import mobile.kikoololasv.fr.smartnotif.trigger.DateTriggerUseCase
import javax.inject.Singleton


@Module
class SmartNotifModule(val context: Context) {

    @Singleton
    @Provides
    fun provideRepo(): SmartNotifsRepository {
        return object : SmartNotifsRepository {
            override fun getSmartNotifs(): List<SmartNotif<*>> {
                return listOf(SmartNotif(title = "Go buy Omelette du fromage", creationDate = 1484513045753L, smartNotifStatus = SmartNotifStatus.PENDING, smartNotifevent = ScheduledEvent(date = 1482585096000L)))
            }
        }
    }

    @Singleton
    @Provides
    fun provideTrigger(): DateTriggerUseCase.TriggeredNotificationCallBack {
        return object : DateTriggerUseCase.TriggeredNotificationCallBack {
            override fun trigger(smartNotif: SmartNotif<*>) {
                val mBuilder = NotificationCompat.Builder(context)
                        .setContentTitle("Smart Notification")
                        .setSmallIcon(R.drawable.notification_template_icon_bg)
                        .setContentText(smartNotif.title)
                val mNotificationId = 1
                val mNotifyMgr = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                mNotifyMgr.notify(mNotificationId, mBuilder.build())

            }
        }
    }
}







