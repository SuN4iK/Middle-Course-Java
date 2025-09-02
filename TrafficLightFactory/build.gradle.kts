plugins {
    id("java")
    id("java-library")
    id("org.jetbrains.kotlin.jvm") version "2.2.0"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "org.example"
version = "1.0-SNAPSHOT"

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.5.3")  // Берём BOM от Spring Boot
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}

tasks.test {
    useJUnitPlatform()
}