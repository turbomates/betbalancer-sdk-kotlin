package com.turbomates.betbalancer.api.response.prematch

import com.turbomates.betbalancer.api.prematch.response.CompetitorsResponse
import com.turbomates.betbalancer.infrastructure.xml
import com.turbomates.betbalancer.model.Competitor
import com.turbomates.betbalancer.model.Names
import com.turbomates.betbalancer.model.Timestamp
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime

class CompetitorsResponseTest {
    @Test
    fun `competitors deserialization`() {
        val response = xml.decodeFromString<CompetitorsResponse>(
            """<?xml version="1.0" encoding="UTF-8"?><BetbalancerBetData><Timestamp CreatedTime="2022-11-08T10:10:01.667Z" TimeZone="UTC" /><Competitors><Competitor CompetitorId="42729"><Texts><Text Language="BET"><Value>Juventus FC</Value></Text><Text Language="it"><Value>Juventus</Value></Text><Text Language="en"><Value>Juventus FC</Value></Text></Texts></Competitor><Competitor CompetitorId="502832"><Texts><Text Language="BET"><Value>AC Milan</Value></Text><Text Language="it"><Value>AC Milan</Value></Text><Text Language="en"><Value>AC Milan</Value></Text></Texts></Competitor></Competitors></BetbalancerBetData>"""
        )
        response.competitors.list.isNotEmpty() shouldBe true
        response.competitors.list.first() shouldBe Competitor(
            42729,
            Names(
                listOf(
                    Names.Name("BET", Names.Name.Value("Juventus FC")),
                    Names.Name("it", Names.Name.Value("Juventus")),
                    Names.Name("en", Names.Name.Value("Juventus FC"))
                )
            )
        )
    }

    @Test
    fun `competitors serialization`() {
        val time = "2022-11-04T09:31:07.140Z"
        val response = CompetitorsResponse(
            Timestamp(OffsetDateTime.parse(time)), CompetitorsResponse.Competitors(
            listOf(
                Competitor(
                    222,
                    Names(listOf(Names.Name("en", Names.Name.Value("Juventus FC")), Names.Name("it", Names.Name.Value("Juventus"))))
                )
            )
        )
        )
        val plain = xml.encodeToString(response)
        plain shouldBe """<BetbalancerBetData><Timestamp CreatedTime="2022-11-04T09:31:07.140Z" TimeZone="UTC"/><Competitors><Competitor CompetitorId="222"><Texts><Text Language="en"><Value>Juventus FC</Value></Text><Text Language="it"><Value>Juventus</Value></Text></Texts></Competitor></Competitors></BetbalancerBetData>"""
    }
}
