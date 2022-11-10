@file:Suppress("SpellCheckingInspection")

package com.turbomates.betbalancer.model.liveodds.bookmakerstatus

import com.turbomates.betbalancer.infrastructure.xml
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.Test
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneOffset

class LoginSerializationTest {
    @Test
    fun `serialization`() {
        val login = Login(1, "testKey")
        val plain = xml.encodeToString(login)
        plain shouldBe """<BookmakerStatus bookmakerid="1" key="testKey" type="login"/>"""
    }

    @Test
    fun `deserialization`() {
        val login = xml.decodeFromString<Login>("""<BookmakerStatus bookmakerid="1" key="testKey" type="login"/>""")
        login.bookmakerId shouldBe 1
        login.key shouldBe "testKey"
        login.type shouldBe BookmakerStatus.Type.LOGIN
    }
}
