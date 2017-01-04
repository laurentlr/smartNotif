package mobile.kikoololasv.fr.smartnotif


data class SmartNotif<T>(val title: String, val creationDate: Long, val smartNotifStatus: SmartNotifStatus, val smartNotifevent: T) {
}