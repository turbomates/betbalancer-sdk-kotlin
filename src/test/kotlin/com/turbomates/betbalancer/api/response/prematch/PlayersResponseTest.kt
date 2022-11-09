package com.turbomates.betbalancer.api.response.prematch

import com.turbomates.betbalancer.infrastructure.xml
import com.turbomates.betbalancer.model.Names
import com.turbomates.betbalancer.model.Player
import com.turbomates.betbalancer.model.Timestamp
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime

class PlayersResponseTest {
    @Test
    fun `players deserialization`() {
        val response = xml.decodeFromString<PlayersResponse>(
            """<?xml version="1.0" encoding="UTF-8"?><BetbalancerBetData><Timestamp CreatedTime="2022-11-08T08:55:35.079Z" TimeZone="UTC" /><Players><Player PlayerId="750"><Texts><Text Language="BET"><Value>Ronaldo, Cristiano</Value></Text><Text Language="it"><Value>Cristiano Ronaldo</Value></Text><Text Language="en"><Value>Ronaldo, Cristiano</Value></Text></Texts></Player><Player PlayerId="12994"><Texts><Text Language="BET"><Value>Messi, Lionel</Value></Text><Text Language="it"><Value>Messi, Lionel</Value></Text><Text Language="en"><Value>Messi, Lionel</Value></Text></Texts></Player></Players></BetbalancerBetData>"""
        )
        response.players.list.isNotEmpty() shouldBe true
        response.players.list.first() shouldBe Player(
            750,
            Names(
                listOf(
                    Names.Name("BET", Names.Name.Value("Ronaldo, Cristiano")),
                    Names.Name("it", Names.Name.Value("Cristiano Ronaldo")),
                    Names.Name("en", Names.Name.Value("Ronaldo, Cristiano"))
                )
            )
        )
    }

    @Test
    fun `players serialization`() {
        val time = "2022-11-04T09:31:07.140Z"
        val response = PlayersResponse(
            Timestamp(OffsetDateTime.parse(time)), PlayersResponse.Players(
            listOf(
                Player(
                    222,
                    Names(listOf(Names.Name("en", Names.Name.Value("Cristiano")), Names.Name("it", Names.Name.Value("Cristiano Bambino"))))
                )
            )
        )
        )
        val plain = xml.encodeToString(response)
        plain shouldBe """<BetbalancerBetData><Timestamp CreatedTime="2022-11-04T09:31:07.140Z" TimeZone="UTC"/><Players><Player PlayerId="222"><Texts><Text Language="en"><Value>Cristiano</Value></Text><Text Language="it"><Value>Cristiano Bambino</Value></Text></Texts></Player></Players></BetbalancerBetData>"""
    }
}
