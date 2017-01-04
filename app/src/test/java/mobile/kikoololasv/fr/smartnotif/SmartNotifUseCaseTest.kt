package mobile.kikoololasv.fr.smartnotif

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test
import org.mockito.BDDMockito.given


class SmartNotifUseCaseTest {

    private var repo: SmartNotifsRepository = mock()

    private lateinit var smartNotifUseCase: SmartNotifUseCase

    private val smartNotifCallBack: SmartNotifCallBack = mock()

    @Test
    fun getSmartNotifs() {
        smartNotifUseCase =  SmartNotifUseCase(repo, smartNotifCallBack)

        var list = listOf(SmartNotif(title = "Go buy Omelette du fromage",creationDate = 1482239496000L,smartNotifStatus = SmartNotifStatus.PENDING,smartNotifevent = ScheduledEvent(date = 1482585096000L)))
        given(repo.getSmartNotifs()).willReturn(list)

        smartNotifUseCase.getSmartNotifs()

        verify(repo).getSmartNotifs()
        verify(smartNotifCallBack).onSuccess(list)
    }


    @Test
    fun getSmartNotifsWhenError() {
        smartNotifUseCase =  SmartNotifUseCase(repo, smartNotifCallBack)
        given(repo.getSmartNotifs()).willThrow(GetSmartNotifsError())

        smartNotifUseCase.getSmartNotifs()

        verify(repo).getSmartNotifs()
        verify(smartNotifCallBack).onError()


    }
}