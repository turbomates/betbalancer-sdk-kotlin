package com.turbomates.betbalancer.api.response.prematch

import com.turbomates.betbalancer.infrastructure.xml
import com.turbomates.betbalancer.model.Market
import com.turbomates.betbalancer.model.Names
import com.turbomates.betbalancer.model.Timestamp
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime

class MarketsResponseTest {
    @Test
    fun `markets deserialization`() {
        val response = xml.decodeFromString<MarketsResponse>(
            """<?xml version="1.0" encoding="UTF-8"?><BetbalancerBetData><Timestamp CreatedTime="2022-11-08T01:09:00.581Z" TimeZone="UTC" /><Sports><Sport BetbalancerSportID="1"><MatchOdds><Bet OddsType="1"><Texts><Text Language="BET"><Value>1x2</Value></Text><Text Language="it"><Value>1x2</Value></Text><Text Language="en"><Value>1x2</Value></Text></Texts></Bet></MatchOdds></Sport></Sports></BetbalancerBetData>"""
        )
        response.sports.list.first().markets.list.isNotEmpty() shouldBe true
        response.sports.list.first().markets.list.first() shouldBe Market(
            1,
            Names(
                listOf(
                    Names.Name("BET", Names.Name.Value("1x2")),
                    Names.Name("it", Names.Name.Value("1x2")),
                    Names.Name("en", Names.Name.Value("1x2"))
                )
            )
        )
    }

    @Test
    fun `markets serialization`() {
        val time = "2022-11-04T09:31:07.140Z"
        val response = MarketsResponse(
            Timestamp(OffsetDateTime.parse(time)),
            MarketsResponse.Sports(
                listOf(
                    MarketsResponse.Sports.Sport(
                        222,
                        MarketsResponse.Markets(listOf(Market(4, Names(listOf(Names.Name("en", Names.Name.Value("1x2")))))))
                    )
                )
            )
        )
        val plain = xml.encodeToString(response)
        plain shouldBe """<BetbalancerBetData><Timestamp CreatedTime="2022-11-04T09:31:07.140Z" TimeZone="UTC"/><Sports><Sport BetbalancerSportID="222"><MatchOdds><Bet OddsType="4"><Texts><Text Language="en"><Value>1x2</Value></Text></Texts></Bet></MatchOdds></Sport></Sports></BetbalancerBetData>"""
    }
}
