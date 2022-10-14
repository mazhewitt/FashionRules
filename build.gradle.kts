import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.4"
    id("io.spring.dependency-management") version "1.0.14.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}



group = "aduki"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

extra["testcontainersVersion"] = "1.17.4"

dependencies {
// Kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

// Spring boot
    implementation("org.springframework.boot:spring-boot-starter")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

// Drools
    implementation("org.kie:kie-spring:7.73.0.Final")
    implementation("org.drools:drools-core:7.73.0.Final")
    compileOnly("org.kie:kie-api:7.73.0.Final")

// Cucumber
// https://mvnrepository.com/artifact/io.cucumber/cucumber-java
    testImplementation("io.cucumber:cucumber-java:7.8.1")
    // https://mvnrepository.com/artifact/io.cucumber/cucumber-junit-platform-engine
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.8.1")
// JUnit 5
    testImplementation("org.junit.platform:junit-platform-suite:1.8.2")
    implementation("org.slf4j:slf4j-api:2.0.3")
    testImplementation("org.assertj:assertj-core:3.23.1")
}

dependencyManagement {
    imports {
        mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
