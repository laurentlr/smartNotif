package fr.kikoololasv.mobile.domain.usecase
import fr.kikoololasv.mobile.domain.SmartNotifsRepository
import fr.kikoololasv.mobile.domain.entity.SmartNotif
import javax.inject.Inject

class GetSmartNotifListUseCase @Inject constructor(var repository: SmartNotifsRepository, var callback: CallBack) {

    fun getSmartNotifs() {
        try {
            callback.onSuccess(repository.getSmartNotifs())

        } catch(e: GetSmartNotifsError) {
            callback.onError()
        }
    }

    interface CallBack {
        fun onError() {
        }

        fun onSuccess(list: List<SmartNotif<*>>) {

        }
    }
}
