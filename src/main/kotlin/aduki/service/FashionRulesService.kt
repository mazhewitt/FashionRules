package aduki.service


import aduki.model.FashionItem
import aduki.model.FashionVerdict
import aduki.model.FashionVerdictResult
import org.kie.api.runtime.KieContainer



class FashionRulesService(private val kieContainer: KieContainer) {

    fun getFashionVerdict(fashionRequest: List<FashionItem>): FashionVerdictResult {
        val kieSession = kieContainer.newKieSession()
        for (item in fashionRequest) {
            kieSession.insert(item)
        }
        val verdict = FashionVerdictResult(FashionVerdict.IT_WORKS, "")
        kieSession.insert(verdict)
        kieSession.fireAllRules()
        kieSession.dispose()

        return verdict
    }
}