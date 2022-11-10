@file:Suppress("SpellCheckingInspection")

package com.turbomates.betbalancer.model.liveodds.bookmakerstatus

import com.turbomates.betbalancer.infrastructure.xml
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.Test

class ScoreAndCardsSummarySerializationTest {
    @Test
    fun `serialization`() {
        val scoreAndCardsSummary = ScoreAndCardsSummary(1, listOf(ScoreAndCardsSummary.Match(2)))
        val plain = xml.encodeToString(scoreAndCardsSummary)
        plain shouldBe """
            <BookmakerStatus bookmakerid="1" type="scoreandcardsummary"><Match matchid="2"/></BookmakerStatus>
        """.trimIndent()
    }

    @Test
    fun `deserialization`() {
        val plain = """<BookmakerStatus bookmakerid="1240" type="scoreandcardsummary"><Match matchid="1355389" /></BookmakerStatus>"""
        val scoreAndCardsSummary = xml.decodeFromString<ScoreAndCardsSummary>(plain)
        scoreAndCardsSummary.bookmakerId shouldBe 1240
        scoreAndCardsSummary.matches.first().id shouldBe 1355389
        scoreAndCardsSummary.type shouldBe BookmakerStatus.Type.SCORE_AND_CARD_SUMMARY
    }
}
