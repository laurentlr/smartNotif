package mobile.kikoololasv.fr.smartnotif

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test


class SmartNotifUseCaseTest {

    @Test
    fun getSmartNotifs() {
        val repo : SmartNotifsRepository = mock()
        val smartNotifUseCase =  SmartNotifUseCase(repo)

        smartNotifUseCase.getSmartNotifs()

        verify(repo).getSmartNotifs()
    }
}