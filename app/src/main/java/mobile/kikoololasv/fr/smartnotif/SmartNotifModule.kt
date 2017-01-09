package mobile.kikoololasv.fr.smartnotif

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SmartNotifModule{

    @Singleton
    @Provides
    fun provideSmartNotifsUseCase(repository: SmartNotifsRepository): SmartNotifUseCase {
        return SmartNotifUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideRepo() : SmartNotifsRepository{
        return object : SmartNotifsRepository {
            override fun getSmartNotifs(): List<SmartNotif<*>> {
                return listOf(SmartNotif(title = "Go buy Omelette du fromage",creationDate = 1482239496000L,smartNotifStatus = SmartNotifStatus.PENDING,smartNotifevent = ScheduledEvent(date = 1482585096000L)))
            }
        }
    }


}

