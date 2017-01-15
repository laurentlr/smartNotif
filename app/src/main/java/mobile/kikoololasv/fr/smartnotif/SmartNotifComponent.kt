package mobile.kikoololasv.fr.smartnotif

import dagger.Component
import mobile.kikoololasv.fr.smartnotif.trigger.DateTriggerUseCase
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(SmartNotifModule::class))
interface SmartNotifComponent {
    fun injectThatSMUSECASESHIT(smartNotifUseCase: SmartNotifUseCase)
    fun injectThat(dateTriggerUseCase: DateTriggerUseCase)

}