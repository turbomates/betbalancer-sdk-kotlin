package com.turbomates.betbalancer.liveodds.response

import LiveOddsDeserializationStrategy
import LiveOddsStatusDeserializationStrategy
import com.turbomates.betbalancer.infrastructure.xml
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import org.junit.jupiter.api.Test

class LiveOddsSerializerTest {
    @Test
    fun `polymorphic serializer`() {
        val loginOkPlain = """
            <BetbalancerLiveOdds status="loginok" timestamp="1184145289891" xmlns="http://www.betbalancer.com/BetbalancerLiveOdds"/>
            """.trimIndent()


        // val message = xml.decodeFromString(LiveOddsStatusDeserializationStrategy, loginOkPlain)
        val message = xml.decodeFromString(LiveOddsDeserializationStrategy, loginOkPlain)
        message shouldBe LoginOk

    }
}
