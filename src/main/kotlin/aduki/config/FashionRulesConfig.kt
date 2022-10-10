package aduki.config



import org.kie.api.KieServices
import org.kie.api.runtime.KieContainer
import org.kie.internal.io.ResourceFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan("aduki")
class FashionRulesConfig {
    @Bean
    fun kieContainer(): KieContainer {
        val kieServices = KieServices.Factory.get()
        val kieFileSystem = kieServices.newKieFileSystem()
        kieFileSystem.write(ResourceFactory.newClassPathResource(drlFile))
        val kieBuilder = kieServices.newKieBuilder(kieFileSystem)
        kieBuilder.buildAll()
        val kieModule = kieBuilder.kieModule
        return kieServices.newKieContainer(kieModule.releaseId)
    }

    companion object {
        private const val drlFile = "aduki/fashionRules.drl"
    }
}