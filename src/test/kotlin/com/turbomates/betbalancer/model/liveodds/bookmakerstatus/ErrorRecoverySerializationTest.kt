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
import java.util.Locale

class ErrorRecoverySerializationTest {
    @Test
    fun `serialization`() {
        val error = ErrorRecovery(1, ErrorRecovery.Match(1, false), 1)
        val plain = xml.encodeToString(error)
        plain shouldBe """
            <BookmakerStatus bookmakerid="1" msgnr="1" type="error"><Match matchid="1" active="0"/></BookmakerStatus>
        """.trimIndent()
    }

    @Test
    fun `deserialization`() {
        val plain = """
            <BookmakerStatus type="error" bookmakerid="24" msgfrom="12" msgto="15"> <Match matchid="661373" active="1" /></BookmakerStatus>
            """.trimIndent()
        val error = xml.decodeFromString<ErrorRecovery>(plain)
        error.bookmakerId shouldBe 24
        error.messageFromId shouldBe 12
        error.messageToId shouldBe 15
        error.timestamp shouldBe null
        error.match.id shouldBe 661_373
        error.match.isActive shouldBe true
        error.type shouldBe BookmakerStatus.Type.ERROR

        Locale("en").getDisplayCountry()
    }
}
