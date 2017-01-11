package mobile.kikoololasv.fr.smartnotif

import com.nhaarman.mockito_kotlin.mock


class SmartNotifUseCaseTest {

    private var repo: SmartNotifsRepository = mock()

    private lateinit var smartNotifUseCase: SmartNotifUseCase

    private val smartNotifCallBack: SmartNotifCallBack = mock()
/*
    @Test
    fun getSmartNotifs() {
        smartNotifUseCase = SmartNotifUseCase(repo)

        var list = listOf(SmartNotif(title = "Go buy Omelette du fromage",creationDate = 1482239496000L,smartNotifStatus = SmartNotifStatus.PENDING,smartNotifevent = ScheduledEvent(date = 1482585096000L)))
        given(repo.getSmartNotifs()).willReturn(list)

        smartNotifUseCase.getSmartNotifs()

        verify(repo).getSmartNotifs()
        verify(smartNotifCallBack).onSuccess(list)
    }


    @Test
    fun getSmartNotifsWhenError() {
        smartNotifUseCase = SmartNotifUseCase(repo)
        given(repo.getSmartNotifs()).willThrow(GetSmartNotifsError())

        smartNotifUseCase.getSmartNotifs()

        verify(repo).getSmartNotifs()
        verify(smartNotifCallBack).onError()


    }*/
}