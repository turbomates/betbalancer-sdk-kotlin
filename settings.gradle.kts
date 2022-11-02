rootProject.name = "betbalancer-sdk"
include("src")
enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    versionCatalogs {
        create("deps") {
            version("ktor", "2.0.3")
            version("log4j", "2.17.1")
            version("kotlin", "1.7.0")
            version("detekt", "1.21.0-RC2")
            version("kotlin_serialization_json", "1.3.1")
            version("kotest", "5.3.2")
            version("kotlinx", "0.3.2")

            library("log4j_slf4j", "org.apache.logging.log4j", "log4j-slf4j-impl").versionRef("log4j")
            library("ktor_client_serialization", "io.ktor", "ktor-client-serialization").versionRef("ktor")
            library("ktor_client_auth_jvm", "io.ktor", "ktor-client-auth-jvm").versionRef("ktor")
            library("ktor_serialization", "io.ktor", "ktor-serialization").versionRef("ktor")
            library("kotlin_test", "org.jetbrains.kotlin", "kotlin-test-junit5").versionRef("kotlin")
            library("serialization_json", "org.jetbrains.kotlinx", "kotlinx-serialization-json").versionRef("kotlin_serialization_json")

            library("kotest", "io.kotest", "kotest-assertions-core").versionRef("kotest")
            library("kotest-jvm", "io.kotest", "kotest-assertions-core-jvm").versionRef("kotest")
            plugin("detekt", "io.gitlab.arturbosch.detekt").versionRef("detekt")
            library("detekt_formatting", "io.gitlab.arturbosch.detekt", "detekt-formatting").versionRef("detekt")
            plugin("kotlin_serialization", "org.jetbrains.kotlin.plugin.serialization").versionRef("kotlin")
        }
    }
}
include("main")
