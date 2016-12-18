package mobile.kikoololasv.fr.smartnotif

import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SmartNotifsPresenterTest {

    @Test
    fun onSuccess() {
        val view: SmartNotifsView = mock()
        val presenter = SmartNotifsPresenter(view)

        val smartNotifs: List<SmartNotif> = listOf(SmartNotif(title = "title"), SmartNotif(title = "title"))
        presenter.onSuccess(smartNotifs)
        smartNotifs.map(::SmartNotifViewModel)
        val captor = argumentCaptor<List<SmartNotifViewModel>>()
        verify(view).displaySmartNotifs(captor.capture())

        var firstValue = captor.firstValue
        assertThat(firstValue.size).isEqualTo(smartNotifs.size)

        for ((index, value) in firstValue.withIndex()) {
            assertThat(smartNotifs[index].title).isEqualTo(value.title)
        }

    }
}