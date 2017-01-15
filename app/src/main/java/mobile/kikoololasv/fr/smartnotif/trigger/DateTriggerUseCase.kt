package mobile.kikoololasv.fr.smartnotif.trigger

import mobile.kikoololasv.fr.smartnotif.SMApplication.Companion.GRAPH
import mobile.kikoololasv.fr.smartnotif.SmartNotif
import mobile.kikoololasv.fr.smartnotif.SmartNotifsRepository
import javax.inject.Inject


class DateTriggerUseCase(){

    @Inject
    lateinit var repo : SmartNotifsRepository

    @Inject
    lateinit var triggerCallBack: TriggeredNotificationCallBack

    val TIME_OFFSET = 120000

    init {
        GRAPH.injectThat(this)
    }

    interface TriggeredNotificationCallBack{
        fun trigger(smartNotif: SmartNotif<*>)
    }

    fun checkDate(date : Long){
        val notifs = repo.getSmartNotifs().filter { (it.creationDate > (date -TIME_OFFSET)) && (it.creationDate < (date +TIME_OFFSET))}
        for (n in notifs) {
            triggerCallBack.trigger(n)
        }
    }

}