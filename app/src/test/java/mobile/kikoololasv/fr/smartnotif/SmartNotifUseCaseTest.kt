package mobile.kikoololasv.fr.smartnotif

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock


class SmartNotifUseCaseTest {

    private var repo: SmartNotifsRepository = mock()

    private lateinit var smartNotifUseCase: SmartNotifUseCase

    private val  presenter: SmartNotifCallBack = mock()

    @Test
    fun getSmartNotifs() {
        smartNotifUseCase =  SmartNotifUseCase(repo,presenter)
        var list = listOf(SmartNotif("title"))
        given(repo.getSmartNotifs()).willReturn(list)

        smartNotifUseCase.getSmartNotifs()

        verify(repo).getSmartNotifs()
        verify(presenter).onSuccess(list)
    }


    @Test
    fun getSmartNotifsWhenError() {
        smartNotifUseCase =  SmartNotifUseCase(repo,presenter)
        given(repo.getSmartNotifs()).willThrow(GetSmartNotifsError())

        smartNotifUseCase.getSmartNotifs()

        verify(repo).getSmartNotifs()
        verify(presenter).onError()


    }
}