package mobile.kikoololasv.fr.smartnotif

class SmartNotifsPresenter(val smartNotifsView: SmartNotifsView) : SmartNotifCallBack {


    override fun onSuccess(smartNotifs: List<SmartNotif>) {
        smartNotifsView.displaySmartNotifs(smartNotifs.map { x -> SmartNotifViewModel(x) })
    }

    fun getSmartNotifs(){
        val repo : SmartNotifsRepository = object : SmartNotifsRepository {
            override fun getSmartNotifs(): List<SmartNotif> {
                return listOf(SmartNotif("hello t"))
            }
        }

        var useCase  = SmartNotifUseCase(repo, this)
        useCase.getSmartNotifs()
    }

    override fun onError() {

    }
}
