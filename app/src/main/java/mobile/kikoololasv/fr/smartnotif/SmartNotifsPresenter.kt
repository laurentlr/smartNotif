package mobile.kikoololasv.fr.smartnotif

class SmartNotifsPresenter(val smartNotifsView: SmartNotifsView) : SmartNotifCallBack {


    override fun onSuccess(smartNotifs: List<SmartNotif<*>>) {
        smartNotifsView.displaySmartNotifs(smartNotifs.map { x -> SmartNotifViewModel(x) })
    }

    fun getSmartNotifs(){
//        val repo : SmartNotifsRepository = object : SmartNotifsRepository {
//            override fun getSmartNotifs(): List<SmartNotif<*>> {
//                return listOf(SmartNotif(title = "Go buy Omelette du fromage",creationDate = 1482239496000L,smartNotifStatus = SmartNotifStatus.PENDING,smartNotifevent = ScheduledEvent(date = 1482585096000L)))
//            }
//        }

        //var useCase  = SmartNotifUseCase(this)
        //Handler().post({ useCase.getSmartNotifs()})
    }

    override fun onError() {

    }
}
