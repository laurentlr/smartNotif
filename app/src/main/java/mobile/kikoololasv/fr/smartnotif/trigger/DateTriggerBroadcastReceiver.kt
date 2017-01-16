package mobile.kikoololasv.fr.smartnotif.trigger

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import java.util.*


class DateTriggerBroadcastReceiver : BroadcastReceiver() {
    private var dateTriggerUseCase: DateTriggerUseCase = DateTriggerUseCase()

    override fun onReceive(p0: Context?, p1: Intent?) {
            dateTriggerUseCase.checkDate(Calendar.getInstance().timeInMillis)

    }
}