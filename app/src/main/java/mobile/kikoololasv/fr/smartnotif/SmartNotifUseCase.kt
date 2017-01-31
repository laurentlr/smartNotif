package mobile.kikoololasv.fr.smartnotif

import io.reactivex.Observable
import mobile.kikoololasv.fr.smartnotif.SMApplication.Companion.GRAPH
import javax.inject.Inject

class SmartNotifUseCase {

    @Inject
    lateinit var repository: SmartNotifsRepository

    init {
        GRAPH.injectThatSMUSECASESHIT(this)
    }

    fun getSmartNotifs() : Observable<List<SmartNotif<*>>> {
       return repository.getSmartNotifs()
    }

}
