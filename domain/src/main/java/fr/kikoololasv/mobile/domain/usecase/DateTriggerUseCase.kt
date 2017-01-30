package fr.kikoololasv.mobile.domain.usecase
import fr.kikoololasv.mobile.domain.SmartNotifsRepository
import fr.kikoololasv.mobile.domain.entity.SmartNotif
import javax.inject.Inject


class DateTriggerUseCase @Inject constructor(var repo : SmartNotifsRepository, var triggerCallBack: TriggeredNotificationCallBack){

    val TIME_OFFSET = 120000


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