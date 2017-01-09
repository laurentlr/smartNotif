package mobile.kikoololasv.fr.smartnotif

interface SmartNotifCallBack {
    fun onError() {
    }

    fun onSuccess(list: List<SmartNotif<*>>) {

    }
}