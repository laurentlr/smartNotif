package mobile.kikoololasv.fr.smartnotif.trigger

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock

import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import io.kotlintest.mock.`when`
import mobile.kikoololasv.fr.smartnotif.SMApplication.Companion.GRAPH
import mobile.kikoololasv.fr.smartnotif.ScheduledEvent
import mobile.kikoololasv.fr.smartnotif.SmartNotif
import mobile.kikoololasv.fr.smartnotif.SmartNotifStatus
import org.jetbrains.spek.api.Spek

class DateTriggerUseCaseTest : Spek({

    describe("date trigger") {

        GRAPH = mock()
        var dateTriggerUseCase = DateTriggerUseCase()
        dateTriggerUseCase.repo = mock()
        dateTriggerUseCase.triggerCallBack = mock()
        `when`(dateTriggerUseCase.repo.getSmartNotifs()).then { listOf(SmartNotif(title = "Go buy Omelette du fromage", creationDate = 1484513045753L, smartNotifStatus = SmartNotifStatus.PENDING, smartNotifevent = ScheduledEvent(date = 1482585096000L))) }


        on("receiving date inside range") {
            dateTriggerUseCase.checkDate(1484513045753L)
            it("should trigger notification") {
                verify(dateTriggerUseCase.triggerCallBack).trigger(any())
            }
        }

        on("receiving date outside range") {
            dateTriggerUseCase.checkDate(13045753L)
            it("should not trigger notification") {

                verify(dateTriggerUseCase.triggerCallBack, never()).trigger(any())

            }
        }
    }
})
