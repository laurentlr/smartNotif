package fr.kikoololasv.mobile.domain.usecase

import fr.kikoololasv.mobile.domain.entity.SmartNotif


class GeoTriggerUseCase() :Trigger{
    interface TriggeredNotificationCallBack<T>{
        fun trigger(smartNotif: SmartNotif<T>)
    }
    override fun trigger() {
    }

}