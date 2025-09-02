plugins {
    id("java")
    id("java-library")
    id("org.jetbrains.kotlin.jvm") version "2.2.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.spring.dependency-management") version "1.1.7"
}
dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.5.3")  // Берём BOM от Spring Boot
    }
}
group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testApi(platform("org.junit:junit-bom:5.10.0"))
    testApi("org.junit.jupiter:junit-jupiter")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")
    testImplementation("org.mockito:mockito-core")
    testImplementation("org.junit.jupiter:junit-jupiter-api") // Основной API
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.mockito:mockito-junit-jupiter")// Для рантайма


}

tasks.test {
    useJUnitPlatform()
}
tasks.withType<JavaExec> {
    systemProperty("file.encoding", "utf-8")
}

tasks.withType<Test> {
    systemProperty("file.encoding", "UTF-8")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
