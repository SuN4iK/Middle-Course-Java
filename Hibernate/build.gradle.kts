plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.spring.dependency-management") version "1.1.7"
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

//BOM
dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.5.3")  // Берём BOM от Spring Boot
    }
}

application {
    mainClass.set("Hibernate.Main")
}

dependencies {
    //Бывшие зависимости
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // Тестовые зависимости
    testImplementation("org.mockito:mockito-core")

    // Hibernate Core
    implementation("org.hibernate:hibernate-core:6.4.4.Final")

    // Database driver (пример для PostgreSQL)
    implementation("org.postgresql:postgresql")

    // HikariCP для connection pool (опционально, но рекомендуется)
    implementation("com.zaxxer:HikariCP")

    // JPA API (если нужен только API)
    implementation("jakarta.persistence:jakarta.persistence-api")
}

tasks.test {
    useJUnitPlatform()
}

tasks.shadowJar {
    archiveBaseName.set("Hibernate-fat")
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

//TODO
//Настоить BOM
//Натсроить проблемы со сканерами