package mobile.kikoololasv.fr.smartnotif

import mobile.kikoololasv.fr.smartnotif.SMApplication.Companion.GRAPH
import javax.inject.Inject

class SmartNotifUseCase(var callback: SmartNotifCallBack) {

    @Inject
    lateinit var repository: SmartNotifsRepository

    init {
        GRAPH.injectThatSMUSECASESHIT(this)
    }

    fun getSmartNotifs() {
        try {
            callback.onSuccess(repository.getSmartNotifs())

        } catch(e: GetSmartNotifsError) {
            callback.onError()
        }
    }


}
