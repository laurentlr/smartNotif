package mobile.kikoololasv.fr.smartnotif

import javax.inject.Inject

class SmartNotifUseCase @Inject constructor(var repository: SmartNotifsRepository, val callback: SmartNotifCallBack) {

    fun getSmartNotifs(){
        try {
            callback.onSuccess(repository.getSmartNotifs())

        } catch( e :GetSmartNotifsError){
            callback.onError()
        }
    }

}
