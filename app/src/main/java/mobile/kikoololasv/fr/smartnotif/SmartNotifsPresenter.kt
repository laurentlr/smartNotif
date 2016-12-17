package mobile.kikoololasv.fr.smartnotif

class SmartNotifsPresenter(val smartNotifsView: SmartNotifsView) {
    fun presentSmartNotifs(smartNotifs: List<SmartNotif>) {
        smartNotifsView.displaySmartNotifs(smartNotifs.map { x -> SmartNotifViewModel(x) })
    }
}
