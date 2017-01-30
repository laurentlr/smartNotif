package fr.kikoololasv.mobile.domain.entity


data class SmartNotif<T>(val title: String, val creationDate: Long, val smartNotifStatus: SmartNotifStatus, val smartNotifevent: T) {
}