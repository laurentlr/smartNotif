package mobile.kikoololasv.fr.smartnotif

import fr.kikoololasv.mobile.domain.entity.SmartNotif

class SmartNotifViewModel(smartNotif: SmartNotif<*>) {
    val title = smartNotif.title
    val creationDate = smartNotif.creationDate
}