val kotlinVersion = kotlin.coreLibrariesVersion     // Specified in plugins block
val ktorVersion = "1.5.3"

plugins {
    java
    kotlin("jvm") version "1.5.0"
}

group = "me.phein"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinVersion-RC")

    // Ktor is a web engine, here used as a web client for the requests to the Binance API.
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio-jvm:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}