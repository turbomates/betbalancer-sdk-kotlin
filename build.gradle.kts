import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    kotlin("jvm").version(deps.versions.kotlin.asProvider().get())
    alias(deps.plugins.detekt)
    alias(deps.plugins.kotlin.serialization)
    `maven-publish`
    signing
}

group = "com.github.turbomates"
version = "0.1.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation(deps.kotest)
    testImplementation(deps.kotest.jvm)
    implementation(deps.ktor.cio)
    implementation(deps.ktor.client.negotiation)
    implementation(deps.ktor.client.serialization.xml)
    implementation(deps.log4j.slf4j)
    implementation(deps.tmsoft.time)
    implementation(kotlin("stdlib-jdk8"))
    detektPlugins(deps.detekt.formatting)
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf(
            "-opt-in=kotlin.RequiresOptIn",
            "-opt-in=kotlinx.serialization.InternalSerializationApi",
            "-opt-in=kotlinx.serialization.ExperimentalSerializationApi",
            "-Xskip-prerelease-check",
            "-Xcontext-receivers"
        )
    }
}
detekt {
    toolVersion = deps.versions.detekt.get()
    autoCorrect = false
    parallel = true
    config = files("detekt.yml")
}
tasks.named("check").configure {
    this.setDependsOn(this.dependsOn.filterNot {
        it is TaskProvider<*> && it.name == "detekt"
    })
}

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}
