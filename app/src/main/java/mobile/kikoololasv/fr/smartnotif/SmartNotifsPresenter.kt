package mobile.kikoololasv.fr.smartnotif

import fr.kikoololasv.mobile.domain.entity.SmartNotif
import fr.kikoololasv.mobile.domain.usecase.GetSmartNotifListUseCase
import org.jetbrains.anko.doAsync
import javax.inject.Inject

class SmartNotifsPresenter(var smartNotifsView: SmartNotifsView) : GetSmartNotifListUseCase.CallBack {

    @Inject
    lateinit var smartNotifUseCase: GetSmartNotifListUseCase

    init {
        smartNotifUseCase = GetSmartNotifListUseCase(this)
    }


    override fun onSuccess(smartNotifs: List<SmartNotif<*>>) {
        smartNotifsView.displaySmartNotifs(smartNotifs.map { x -> SmartNotifViewModel(x) })
    }

    fun getSmartNotifs() {
//        val repo : SmartNotifsRepository = object : SmartNotifsRepository {
//            override fun getSmartNotifs(): List<SmartNotif<*>> {
//                return listOf(SmartNotif(title = "Go buy Omelette du fromage",creationDate = 1482239496000L,smartNotifStatus = SmartNotifStatus.PENDING,smartNotifevent = ScheduledEvent(date = 1482585096000L)))
//            }
//        }

        //var useCase  = SmartNotifUseCase(this)
        doAsync { smartNotifUseCase.getSmartNotifs() }
    }

    override fun onError() {

    }
}
