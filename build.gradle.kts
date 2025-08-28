plugins {
	java
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.graalvm.buildtools.native") version "0.10.6"
	id("org.owasp.dependencycheck") version "12.1.3"
    id("org.sonarqube") version "6.3.1.5724"
}

group = "com.centricsoftware"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Semgrep"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("com.h2database:h2")
    implementation("jakarta.inject:jakarta.inject-api")



	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyLocking {
    lockAllConfigurations()
}

dependencyCheck {

    autoUpdate = false
    failOnError = false
    formats = listOf("HTML", "JSON")

    nvd {
        apiKey = "6bbd31cf-44d0-4114-8ad8-09e2a9bbbbc8"
        maxRetryCount = 3
        delay = 4000
    }

    data {
        driver = "org.postgresql.Driver"
        driverPath = "C:/Users/masud.habib/.m2/repository/org/postgresql/postgresql/42.7.5/postgresql-42.7.5.jar"
        connectionString = "jdbc:postgresql://localhost:5430/dependencycheck?useSSL=false"
        username ="postgres"
        password ="postgres1"
    }

        analyzers {
            centralEnabled = true
            nexusEnabled = true
            assemblyEnabled = false
            autoconfEnabled = false
        }

}

sonarqube {
    properties {
        property("sonar.projectKey", "vulnerable-project-poc-semgrep")
        property("sonar.host.url", "http://localhost:9001")
        property("sonar.login", "sqp_01bbafb34ec36c5466335e8a52cdb9681d63fffa")
    }
}

tasks.withType<Test> {
	useJUnitPlatform()
}
