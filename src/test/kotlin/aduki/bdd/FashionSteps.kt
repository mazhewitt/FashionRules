package aduki.bdd

import aduki.config.FashionRulesConfig
import aduki.service.FashionRulesService
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll

class FashionSteps {
    @Given("brown shoes and a red handbag")
    fun brownShoesAndARedHandbag() {

    }

    @Then("the the fashion police say FAUX_PAS")
    fun theTheFashionPoliceSayFAUX_PAS() {
        assertThat(true).isEqualTo(true)
    }

    companion object {
        @JvmStatic
        lateinit var fashionRulesService: FashionRulesService

        @JvmStatic
        val testContainer = FashionRulesConfig()

        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            fashionRulesService = FashionRulesService(testContainer.kieContainer())
        }
    }

}