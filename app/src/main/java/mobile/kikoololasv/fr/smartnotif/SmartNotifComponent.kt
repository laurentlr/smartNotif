package mobile.kikoololasv.fr.smartnotif

import dagger.Component
import fr.kikoololasv.mobile.domain.usecase.DateTriggerUseCase
import fr.kikoololasv.mobile.domain.usecase.GetSmartNotifListUseCase
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(SmartNotifModule::class))
interface SmartNotifComponent {
    fun injectThatSMUSECASESHIT(smartNotifUseCase: GetSmartNotifListUseCase)
    fun injectThat(dateTriggerUseCase: DateTriggerUseCase)

}