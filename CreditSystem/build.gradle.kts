plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(23))
    }
}

application {
    // Укажи здесь свой main-класс
    mainClass.set("CreditSystem.CreditSystemDemo")
}

dependencies {
    //Бывшие зависимости
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Spring Boot BOM для управления версиями зависимостей
    implementation(platform("org.springframework.boot:spring-boot-dependencies:3.3.4"))

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    // Тестовые зависимости
    testImplementation("org.mockito:mockito-core:5.14.2")
}

tasks.test {
    useJUnitPlatform()
}
tasks.shadowJar {
    archiveBaseName.set("CreditSystem-fat")
    archiveClassifier.set("")
    archiveVersion.set("")
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
tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
