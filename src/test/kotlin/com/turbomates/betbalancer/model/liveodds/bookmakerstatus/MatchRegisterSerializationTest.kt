@file:Suppress("SpellCheckingInspection")

package com.turbomates.betbalancer.model.liveodds.bookmakerstatus

import com.turbomates.betbalancer.infrastructure.xml
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.Test

class MatchRegisterSerializationTest {
    @Test
    fun `serialization`() {
        val match1 = MatchRegister.Match(1)
        val match2 = MatchRegister.Match(2, listOf(MatchRegister.Odds(1), MatchRegister.Odds(2, 3)))
        val matchRegister = MatchRegister(1, listOf(match1, match2))
        val plain = xml.encodeToString(matchRegister)
        plain shouldBe """
            <BookmakerStatus bookmakerid="1" type="register"><Match matchid="1"/><Match matchid="2"><Odds typeid="1"/><Odds typeid="2" subtype="3"/></Match></BookmakerStatus>
        """.trimIndent()
    }

    @Test
    fun `deserialization`() {
        val plain = """<BookmakerStatus bookmakerid="24" type="register"><Match matchid="661373"/></BookmakerStatus>"""
        val matchRegister = xml.decodeFromString<MatchRegister>(plain)
        matchRegister.bookmakerId shouldBe 24
        matchRegister.matches.first().id shouldBe 661373
        matchRegister.type shouldBe BookmakerStatus.Type.REGISTER
    }
}
