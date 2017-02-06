package mobile.kikoololasv.fr.smartnotif

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.mockito.BDDMockito

class SmartNotifUseCaseTest : Spek({

    val repo: SmartNotifsRepository = mock()
    var smartNotifs: Observable<List<SmartNotif<*>>>
    val testObserver = TestObserver<List<SmartNotif<*>>>()
    val aSmartNotif = SmartNotif("title", 123, SmartNotifStatus.DONE, null)
    BDDMockito.given(repo.getSmartNotifs()).willReturn(Observable.just(listOf(aSmartNotif)))

    describe("a SmartNotifUseCase") {

        val smartNotif = SmartNotifUseCase(repo)

        on("get smartnotifs") {
            smartNotifs = smartNotif.getSmartNotifs()
            smartNotifs.subscribe(testObserver)

            it("should call repository") {
                verify(smartNotif.repository).getSmartNotifs()
            }

            it("should return the smartNotif of the repository") {
                testObserver.assertComplete()
                assertThat(testObserver.values()[0][0].title).isEqualTo("title")
            }
        }
    }
})