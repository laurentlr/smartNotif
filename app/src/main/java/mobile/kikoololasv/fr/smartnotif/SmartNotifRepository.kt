package mobile.kikoololasv.fr.smartnotif

interface SmartNotifsRepository{

    @Throws(GetSmartNotifsError::class)
    fun getSmartNotifs() : List<SmartNotif<*>>
}

