@file:Suppress("SpellCheckingInspection")

package com.turbomates.betbalancer.model.liveodds.bookmakerstatus

import com.turbomates.betbalancer.infrastructure.xml
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.Test

class MatchUnregisterSerializationTest {
    @Test
    fun `serialization`() {
        val matchUnregister = MatchUnregister(1, listOf(MatchUnregister.Match(2, listOf(MatchUnregister.Odds(1)))))
        val plain = xml.encodeToString(matchUnregister)
        plain shouldBe """
            <BookmakerStatus bookmakerid="1" type="unregister"><Match matchid="2"><Odds typeid="1"/></Match></BookmakerStatus>
        """.trimIndent()
    }

    @Test
    fun `deserialization`() {
        val plain = """<BookmakerStatus bookmakerid="24" type="unregister"><Match matchid="661373"><Odds typeid="5"/></Match></BookmakerStatus>"""
        val matchUnregister = xml.decodeFromString<MatchUnregister>(plain)
        matchUnregister.bookmakerId shouldBe 24
        matchUnregister.matches.first().id shouldBe 661373
        matchUnregister.matches.first().odds?.first()?.typeId shouldBe 5
        matchUnregister.type shouldBe BookmakerStatus.Type.UNREGISTER
    }
}
