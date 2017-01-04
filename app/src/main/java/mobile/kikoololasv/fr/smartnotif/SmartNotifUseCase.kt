package mobile.kikoololasv.fr.smartnotif

class SmartNotifUseCase(var repository: SmartNotifsRepository, val callback: SmartNotifCallBack) {

    fun getSmartNotifs(){
        try {
            callback.onSuccess(repository.getSmartNotifs())

        } catch( e :GetSmartNotifsError){
            callback.onError()
        }
    }

}
