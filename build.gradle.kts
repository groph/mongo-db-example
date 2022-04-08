plugins {
	id("java")
	id("org.springframework.boot") version "2.6.6"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("io.freefair.lombok") version "6.4.2"
}

val applicationVersion: String by project

group = "org.imperfect.examples.mongo"
version = applicationVersion

java {
	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
	implementation("org.springframework.boot:spring-boot-starter-webflux")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")
	testImplementation("io.projectreactor:reactor-test")
}

tasks.getByName<Test>("test") {
	useJUnitPlatform()
}
