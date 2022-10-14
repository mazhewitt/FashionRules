package aduki.bdd

import aduki.config.FashionRulesConfig
import aduki.model.FashionItem
import aduki.model.FashionVerdict
import aduki.service.FashionRulesService
import aduki.service.RulesTests
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll

class FashionSteps {
    val fashionItems =  mutableListOf<FashionItem>()
    val testContainer = FashionRulesConfig()
    var fashionRulesService: FashionRulesService = FashionRulesService(testContainer.kieContainer())
    @Given("{string} {string} and a {string} {string}")
    fun shoesAndAHandbag(colour1:String, item1:String, colour2:String, item2:String) {
        fashionItems.add(FashionItem(colour1, item1))
        fashionItems.add(FashionItem(colour2, item2))
    }

    @Then("The fashion police say {string}")
    fun theTheFashionPoliceSay(verdictString:String) {
        val verdict = fashionRulesService.getFashionVerdict(fashionItems)
        assertThat(verdict.verdict).isEqualTo(FashionVerdict.valueOf(verdictString))
    }



}