package mobile.kikoololasv.fr.smartnotif

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(SmartNotifModule::class))
interface SmartNotifComponent {
    fun inject(smartNotifsActivity: SmartNotifsActivity)
}