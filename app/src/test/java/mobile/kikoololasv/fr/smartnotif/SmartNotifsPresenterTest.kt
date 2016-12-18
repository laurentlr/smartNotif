package mobile.kikoololasv.fr.smartnotif

import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SmartNotifsPresenterTest {

    @Test
    fun presentSmartNotifs() {
        val view: SmartNotifsView = mock()
        val presenter = SmartNotifsPresenter(view)

        val smartNotifs: List<SmartNotif> = listOf(SmartNotif(title = "title"), SmartNotif(title = "title"))
        presenter.presentSmartNotifs(smartNotifs)
        smartNotifs.map(::SmartNotifViewModel)
        val captor = argumentCaptor<List<SmartNotifViewModel>>()
        verify(view).displaySmartNotifs(captor.capture())

        assertThat(captor.firstValue.size).isEqualTo(smartNotifs.size)

        for ((index, value) in captor.firstValue.withIndex()) {
            assertThat(smartNotifs[index].title).isEqualTo(value.title)
        }

    }
}