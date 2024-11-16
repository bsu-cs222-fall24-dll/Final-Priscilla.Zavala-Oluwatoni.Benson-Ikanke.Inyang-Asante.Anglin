plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.jayway.jsonpath:json-path:2.9.0")
    implementation("net.minidev:json-smart:2.5.0")
    implementation("ch.qos.logback:logback-classic:1.4.12")
    implementation("io.github.cdimascio:java-dotenv:5.2.2")
}

tasks.test {
    useJUnitPlatform()
}