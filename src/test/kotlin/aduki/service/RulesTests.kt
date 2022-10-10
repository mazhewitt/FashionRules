package aduki.service

import aduki.config.FashionRulesConfig
import aduki.model.FashionItem
import aduki.model.FashionVerdict
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat


class RulesTests {


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

    @Test
    fun testRulesSession(){
        val fashionItems = listOf(FashionItem("Brown", "handbag"), FashionItem("Red", "shoes"))
        val verdict = fashionRulesService.getFashionVerdict(fashionItems)
        assertThat(verdict.verdict).isEqualTo(FashionVerdict.FAUX_PAS)
    }
}