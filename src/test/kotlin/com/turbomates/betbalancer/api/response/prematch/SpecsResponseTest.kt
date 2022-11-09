@file:Suppress("SpellCheckingInspection")

package com.turbomates.betbalancer.api.response.prematch

import com.turbomates.betbalancer.api.prematch.response.SpecsResponse
import com.turbomates.betbalancer.infrastructure.xml
import com.turbomates.betbalancer.model.Names
import com.turbomates.betbalancer.model.Timestamp
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime

class SpecsResponseTest {
    @Test
    fun `specs deserialization`() {
        val response = xml.decodeFromString<SpecsResponse>(
            """<?xml version="1.0" encoding="UTF-8"?><BetbalancerBetData><Timestamp CreatedTime="2022-11-08T09:13:02.604Z" TimeZone="UTC" /><Sports><Sport BetbalancerSportID="1"><MatchOdds><Bet OddsType="9"><Odds OutCome="" OutComeId="6" SpecialBetValue="0"><Texts><Text Language="BET"><Value>{"$"competitor1}</Value></Text><Text Language="it"><Value>{"$"competitor1}</Value></Text><Text Language="en"><Value>{"$"competitor1}</Value></Text></Texts></Odds><Odds OutCome="" OutComeId="7" SpecialBetValue="0"><Texts><Text Language="BET"><Value>none</Value></Text><Text Language="it"><Value>nessuno</Value></Text><Text Language="en"><Value>none</Value></Text></Texts></Odds><Odds OutCome="" OutComeId="8" SpecialBetValue="0"><Texts><Text Language="BET"><Value>{"$"competitor2}</Value></Text><Text Language="it"><Value>{"$"competitor2}</Value></Text><Text Language="en"><Value>{"$"competitor2}</Value></Text></Texts></Odds></Bet></MatchOdds></Sport></Sports></BetbalancerBetData>""".trimIndent()
        )
        response.sports.list.first().markets.list.first().odds.isNotEmpty() shouldBe true
        response.sports.list.first().markets.list.first().odds.first() shouldBe SpecsResponse.Odd(
            6,
            "",
            "0",
            Names(
                listOf(
                    Names.Name("BET", Names.Name.Value("""{"$"competitor1}""")),
                    Names.Name("it", Names.Name.Value("""{"$"competitor1}""")),
                    Names.Name("en", Names.Name.Value("""{"$"competitor1}"""))
                )
            )
        )
    }

    @Test
    fun `specs serialization`() {
        val time = "2022-11-04T09:31:07.140Z"
        val response = SpecsResponse(
            Timestamp(OffsetDateTime.parse(time)),
            SpecsResponse.Sports(
                listOf(
                    SpecsResponse.Sports.Sport(
                        222,
                        SpecsResponse.Markets(
                            listOf(
                                SpecsResponse.Market(
                                    4,
                                    listOf(SpecsResponse.Odd(1, "1", "2x1", Names(listOf(Names.Name("en", Names.Name.Value("competitor1"))))))
                                )
                            )
                        )
                    )
                )
            )
        )
        val plain = xml.encodeToString(response)
        plain shouldBe """<BetbalancerBetData><Timestamp CreatedTime="2022-11-04T09:31:07.140Z" TimeZone="UTC"/><Sports><Sport BetbalancerSportID="222"><MatchOdds><Bet OddsType="4"><Odds OutComeId="1" OutCome="1" SpecialBetValue="2x1"><Texts><Text Language="en"><Value>competitor1</Value></Text></Texts></Odds></Bet></MatchOdds></Sport></Sports></BetbalancerBetData>"""
    }
}
