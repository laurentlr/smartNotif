package mobile.kikoololasv.fr.smartnotif

import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import javax.inject.Singleton


@Module
class SmartNotifModule(val context: Context) {

    @Singleton
    @Provides
    fun provideSMUC(repo: SmartNotifsRepository): SmartNotifUseCase {
        return SmartNotifUseCase(repo)
    }

    @Singleton
    @Provides
    fun provideRepo(): SmartNotifsRepository {
        return object : SmartNotifsRepository {
            override fun getSmartNotifs(): Observable<List<SmartNotif<*>>> {
                val listOf = listOf(SmartNotif(title = "Go buy Omelette du fromage", creationDate = 1484513045753L, smartNotifStatus = SmartNotifStatus.PENDING, smartNotifevent = ScheduledEvent(date = 1482585096000L)))
                return Observable.create({
                    it.onNext(listOf)
                    it.onComplete()
                })
            }
        }
    }

/* @Singleton
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
 }*/
}







