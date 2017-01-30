package mobile.kikoololasv.fr.smartnotif

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