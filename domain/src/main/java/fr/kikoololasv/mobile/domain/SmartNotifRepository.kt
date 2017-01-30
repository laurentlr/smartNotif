package fr.kikoololasv.mobile.domain

import fr.kikoololasv.mobile.domain.entity.SmartNotif
import fr.kikoololasv.mobile.domain.usecase.GetSmartNotifsError

interface SmartNotifsRepository{

    @Throws(GetSmartNotifsError::class)
    fun getSmartNotifs() : List<SmartNotif<*>>
}

