@file:Suppress("SpellCheckingInspection")

package com.turbomates.betbalancer.model

import com.turbomates.betbalancer.infrastructure.xml
import com.turbomates.betbalancer.model.bookmakerstatus.BookmakerStatus
import com.turbomates.betbalancer.model.bookmakerstatus.Current
import com.turbomates.betbalancer.model.bookmakerstatus.ErrorRecovery
import com.turbomates.betbalancer.model.bookmakerstatus.Login
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.Test
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneOffset

class BookmakerStatusSerializationTest {
    @Test
    fun `login serialization`() {
        val login = Login(1, "testKey")
        val plain = xml.encodeToString(login)
        plain shouldBe """<BookmakerStatus bookmakerid="1" key="testKey" type="login"/>"""
    }

    @Test
    fun `login deserialization`() {
        val login = xml.decodeFromString<Login>("""<BookmakerStatus bookmakerid="1" key="testKey" type="login"/>""")
        login.bookmakerId shouldBe 1
        login.key shouldBe "testKey"
        login.type shouldBe BookmakerStatus.Type.LOGIN
    }

    @Test
    fun `current serialization`() {
        val now = OffsetDateTime.now()
        val current = Current(1, now, Current.Match(1))
        val plain = xml.encodeToString(current)
        val timestmapNow = now.toInstant().toEpochMilli()
        plain shouldBe """
            <BookmakerStatus bookmakerid="1" timestamp="$timestmapNow" type="current"><Match matchid="1"/></BookmakerStatus>
        """.trimIndent()
    }

    @Test
    fun `current deserialization`() {
        val plain = """<BookmakerStatus bookmakerid="1" timestamp="0" type="current"><Match matchid="1"/></BookmakerStatus>"""
        val current = xml.decodeFromString<Current>(plain)
        current.bookmakerId shouldBe 1
        current.timestamp shouldBe OffsetDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC)
        current.match.id shouldBe 1
        current.type shouldBe BookmakerStatus.Type.CURRENT
    }

    @Test
    fun `error recovery serialization`() {
        val error = ErrorRecovery(1, ErrorRecovery.Match(1, false), 1)
        val plain = xml.encodeToString(error)
        plain shouldBe """
            <BookmakerStatus bookmakerid="1" msgnr="1" type="error"><Match matchid="1" active="0"/></BookmakerStatus>
        """.trimIndent()
    }

    @Test
    fun `error recovery deserialization`() {
        val plain = """
            <BookmakerStatus type="error" bookmakerid="24" msgfrom="12" msgto="15"> <Match matchid="661373" active="1" /></BookmakerStatus>
            """.trimIndent()
        val error = xml.decodeFromString<ErrorRecovery>(plain)
        error.bookmakerId shouldBe 24
        error.messageFromId shouldBe 12
        error.messageToId shouldBe 15
        error.timestamp shouldBe null
        error.match.id shouldBe 661373
        error.match.isActive shouldBe true
        error.type shouldBe BookmakerStatus.Type.ERROR
    }
}
