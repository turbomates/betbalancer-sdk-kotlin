@file:Suppress("SpellCheckingInspection")

package com.turbomates.betbalancer.api.response.prematch

import com.turbomates.betbalancer.infrastructure.xml
import com.turbomates.betbalancer.model.Names
import com.turbomates.betbalancer.model.Outcome
import com.turbomates.betbalancer.model.Timestamp
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime

class OutcomesResponseTest {
    @Test
    fun `outrights deserialization`() {
        val response = xml.decodeFromString<OutcomesResponse>(
            """<?xml version="1.0" encoding="UTF-8"?><BetbalancerBetData><Timestamp CreatedTime="2022-11-08T13:39:59.657Z" TimeZone="UTC" /><Competitors><Texts><Text ID="58880"><Text Language="BET"><Value>Nebraska Cornhuskers</Value></Text><Text Language="it"><Value>Nebraska Cornhuskers</Value></Text><Text Language="en"><Value>Nebraska Cornhuskers</Value></Text></Text><Text ID="58879"><Text Language="BET"><Value>New Mexico State Aggies</Value></Text><Text Language="it"><Value>New Mexico State Aggies</Value></Text><Text Language="en"><Value>New Mexico State Aggies</Value></Text></Text><Text ID="58881"><Text Language="BET"><Value>TCU Horned Frogs</Value></Text><Text Language="it"><Value>TCU Horned Frogs</Value></Text><Text Language="en"><Value>TCU Horned Frogs</Value></Text></Text></Texts></Competitors></BetbalancerBetData>"""
        )
        response.competitors.outcomes.list.isNotEmpty() shouldBe true
        response.competitors.outcomes.list.first() shouldBe Outcome(
            58880,
            listOf(
                Names.Name("BET", Names.Name.Value("Nebraska Cornhuskers")),
                Names.Name("it", Names.Name.Value("Nebraska Cornhuskers")),
                Names.Name("en", Names.Name.Value("Nebraska Cornhuskers"))
            )
        )
    }

    @Test
    fun `outrights serialization`() {
        val time = "2022-11-04T09:31:07.140Z"
        val response = OutcomesResponse(
            Timestamp(OffsetDateTime.parse(time)), OutcomesResponse.Competitors(
            OutcomesResponse.Outcomes(
                listOf(
                    Outcome(
                        222,
                        listOf(
                            Names.Name("en", Names.Name.Value("Nebraska Cornhuskers")),
                            Names.Name("it", Names.Name.Value("Nebraska Cornhuskers 2"))
                        )
                    )
                )
            )
        )
        )
        val plain = xml.encodeToString(response)
        plain shouldBe """<BetbalancerBetData><Timestamp CreatedTime="2022-11-04T09:31:07.140Z" TimeZone="UTC"/><Competitors><Texts><Text ID="222"><Text Language="en"><Value>Nebraska Cornhuskers</Value></Text><Text Language="it"><Value>Nebraska Cornhuskers 2</Value></Text></Text></Texts></Competitors></BetbalancerBetData>"""
    }
}
