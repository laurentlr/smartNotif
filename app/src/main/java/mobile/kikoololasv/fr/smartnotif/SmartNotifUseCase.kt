package mobile.kikoololasv.fr.smartnotif

class SmartNotifUseCase(val repository: SmartNotifsRepository) {

    fun getSmartNotifs() {
        repository.getSmartNotifs()
    }

}
