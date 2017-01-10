package mobile.kikoololasv.fr.smartnotif

import android.os.Handler
import mobile.kikoololasv.fr.smartnotif.SMApplication.Companion.GRAPH
import javax.inject.Inject

class SmartNotifsPresenter(var smartNotifsView: SmartNotifsView) : SmartNotifCallBack {

    @Inject
    lateinit var smartNotifUseCase: SmartNotifUseCase

    init {
        GRAPH.inject(this)
    }


    override fun onSuccess(smartNotifs: List<SmartNotif<*>>) {
        //smartNotifsView.displaySmartNotifs(smartNotifs.map { x -> SmartNotifViewModel(x) })
    }

    fun getSmartNotifs() {
//        val repo : SmartNotifsRepository = object : SmartNotifsRepository {
//            override fun getSmartNotifs(): List<SmartNotif<*>> {
//                return listOf(SmartNotif(title = "Go buy Omelette du fromage",creationDate = 1482239496000L,smartNotifStatus = SmartNotifStatus.PENDING,smartNotifevent = ScheduledEvent(date = 1482585096000L)))
//            }
//        }

        //var useCase  = SmartNotifUseCase(this)
        Handler().post({ smartNotifUseCase.getSmartNotifs() })
    }

    override fun onError() {

    }
}
