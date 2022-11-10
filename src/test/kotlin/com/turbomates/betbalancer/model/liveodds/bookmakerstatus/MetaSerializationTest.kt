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

class MetaSerializationTest {
    @Test
    fun `serialization`() {
        val matches = listOf(Meta.Match(1), Meta.Match(2))
        val meta = Meta(1, matches = matches)
        val plain = xml.encodeToString(meta)
        plain shouldBe """
            <BookmakerStatus bookmakerid="1" type="meta"><Match matchid="1"/><Match matchid="2"/></BookmakerStatus>
        """.trimIndent()
    }

    @Test
    fun `deserialization`() {
        val plain = """
            <BookmakerStatus bookmakerid="24" metafrom="0" includeavailable="true" type="meta"><Match matchid="1"/></BookmakerStatus>
        """.trimIndent()
        val meta = xml.decodeFromString<Meta>(plain)
        meta.bookmakerId shouldBe 24
        meta.metaFrom shouldBe OffsetDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC)
        meta.metaTo shouldBe null
        meta.includeAvailable shouldBe true
        meta.matches.first().id shouldBe 1
        meta.type shouldBe BookmakerStatus.Type.META
    }
}
