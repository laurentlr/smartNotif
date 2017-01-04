package mobile.kikoololasv.fr.smartnotif

class SmartNotifViewModel(smartNotif: SmartNotif<*>) {
    val title = smartNotif.title
    val creationDate = smartNotif.creationDate
}