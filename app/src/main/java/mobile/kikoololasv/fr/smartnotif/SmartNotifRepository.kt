package mobile.kikoololasv.fr.smartnotif

import io.reactivex.Observable

interface SmartNotifsRepository{

    @Throws(GetSmartNotifsError::class)
    fun getSmartNotifs(): Observable<List<SmartNotif<*>>>
}

