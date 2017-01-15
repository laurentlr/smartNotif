package mobile.kikoololasv.fr.smartnotif.trigger

import mobile.kikoololasv.fr.smartnotif.SmartNotif


class GeoTriggerUseCase() :Trigger{
    interface TriggeredNotificationCallBack<T>{
        fun trigger(smartNotif: SmartNotif<T>)
    }
    override fun trigger() {
    }

}