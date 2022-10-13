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
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.testcontainers:junit-jupiter")
// Drools
    implementation("org.kie:kie-spring:7.73.0.Final")
    implementation("org.drools:drools-core:7.73.0.Final")
    compileOnly("org.kie:kie-api:7.73.0.Final")
    testImplementation ("org.junit.jupiter:junit-jupiter:5.9.0")
    testImplementation("org.assertj:assertj-core:3.23.1")

    // cucumber
    // https://mvnrepository.com/artifact/io.cucumber/cucumber-java
    testImplementation("io.cucumber:cucumber-java:7.8.1")
    testImplementation("io.cucumber:cucumber-spring:7.8.1")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.8.1")
// https://mvnrepository.com/artifact/org.junit.platform/junit-platform-suite-api
    testImplementation("org.junit.platform:junit-platform-suite-api:1.9.1")


    // https://mvnrepository.com/artifact/org.slf4j/slf4j-api
    implementation("org.slf4j:slf4j-api:2.0.3")

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
