package mobile.kikoololasv.fr.smartnotif

import io.reactivex.Observable

class SmartNotifUseCase(val repository: SmartNotifsRepository) {

    fun getSmartNotifs() : Observable<List<SmartNotif<*>>> {
       return repository.getSmartNotifs()
    }

}
