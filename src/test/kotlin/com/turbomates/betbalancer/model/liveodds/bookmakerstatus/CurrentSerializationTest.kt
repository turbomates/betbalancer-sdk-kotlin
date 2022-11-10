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

class CurrentSerializationTest {
    @Test
    fun `serialization`() {
        val now = OffsetDateTime.now()
        val current = Current(1, now, Current.Match(1))
        val plain = xml.encodeToString(current)
        val timestmapNow = now.toInstant().toEpochMilli()
        plain shouldBe """
            <BookmakerStatus bookmakerid="1" timestamp="$timestmapNow" type="current"><Match matchid="1"/></BookmakerStatus>
        """.trimIndent()
    }

    @Test
    fun `deserialization`() {
        val plain = """<BookmakerStatus bookmakerid="1" timestamp="0" type="current"><Match matchid="1"/></BookmakerStatus>"""
        val current = xml.decodeFromString<Current>(plain)
        current.bookmakerId shouldBe 1
        current.timestamp shouldBe OffsetDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC)
        current.match.id shouldBe 1
        current.type shouldBe BookmakerStatus.Type.CURRENT
    }
}
