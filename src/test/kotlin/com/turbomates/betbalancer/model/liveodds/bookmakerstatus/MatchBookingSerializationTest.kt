@file:Suppress("SpellCheckingInspection")

package com.turbomates.betbalancer.model.liveodds.bookmakerstatus

import com.turbomates.betbalancer.infrastructure.xml
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.Test

class MatchBookingSerializationTest {
    @Test
    fun `serialization`() {
        val matchBooking = MatchBooking(1, listOf(MatchBooking.Match(2), MatchBooking.Match(3)))
        val plain = xml.encodeToString(matchBooking)
        plain shouldBe """
            <BookmakerStatus bookmakerid="1" type="bookmatch"><Match matchid="2"/><Match matchid="3"/></BookmakerStatus>
        """.trimIndent()
    }

    @Test
    fun `deserialization`() {
        val plain = """<BookmakerStatus bookmakerid="24" type="bookmatch"> <Match matchid="1291016" /></BookmakerStatus>"""
        val matchBooking = xml.decodeFromString<MatchBooking>(plain)
        matchBooking.bookmakerId shouldBe 24
        matchBooking.matches.first().id shouldBe 1291016
        matchBooking.type shouldBe BookmakerStatus.Type.BOOK_MATCH
    }
}
