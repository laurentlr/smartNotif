package fr.kikoololasv.mobile.domain
import fr.kikoololasv.mobile.domain.usecase.GeoTriggerUseCase
import org.jetbrains.spek.api.Spek
class SMTriggerUseCaseTest : Spek({


    describe("a trigger") {
        val triggerUseCase = GeoTriggerUseCase()


        on("notification") {
            triggerUseCase.trigger()

        }

        it("should execute action on its geofencing executor") {
        }
    }

})