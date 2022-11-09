@file:Suppress("SpellCheckingInspection")

package com.turbomates.betbalancer.api.prematch.response

import com.turbomates.betbalancer.infrastructure.xml
import com.turbomates.betbalancer.model.Names
import com.turbomates.betbalancer.model.Timestamp
import com.turbomates.betbalancer.model.Tournament
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime

class TournamentsResponseTest {
    @Test
    fun `tournaments deserialization`() {
        val response = xml.decodeFromString<TournamentsResponse>(
            """<?xml version="1.0" encoding="UTF-8"?><BetbalancerBetData><Timestamp CreatedTime="2022-11-07T12:21:34.789Z" TimeZone="UTC" /><Sports><Sport BetbalancerSportID="1"><Category BetbalancerCategoryID="1"><Tournament BetbalancerTournamentID="17"><Texts><Text Language="BET"><Value>Premier League</Value></Text><Text Language="it"><Value>Premier League</Value></Text><Text Language="en"><Value>Premier League</Value></Text></Texts></Tournament><Tournament BetbalancerTournamentID="18"><Texts><Text Language="BET"><Value>Championship</Value></Text><Text Language="it"><Value>Championship</Value></Text><Text Language="en"><Value>Championship</Value></Text></Texts></Tournament><Tournament BetbalancerTournamentID="19"><Texts><Text Language="BET"><Value>FA Cup</Value></Text><Text Language="it"><Value>FA Cup</Value></Text><Text Language="en"><Value>FA Cup</Value></Text></Texts></Tournament><Tournament BetbalancerTournamentID="21"><Texts><Text Language="BET"><Value>EFL Cup</Value></Text><Text Language="it"><Value>EFL Cup</Value></Text><Text Language="en"><Value>EFL Cup</Value></Text></Texts></Tournament><Tournament BetbalancerTournamentID="24"><Texts><Text Language="BET"><Value>League One</Value></Text><Text Language="it"><Value>League One</Value></Text><Text Language="en"><Value>League One</Value></Text></Texts></Tournament><Tournament BetbalancerTournamentID="25"><Texts><Text Language="BET"><Value>League Two</Value></Text><Text Language="it"><Value>League Two</Value></Text><Text Language="en"><Value>League Two</Value></Text></Texts></Tournament><Tournament BetbalancerTournamentID="173"><Texts><Text Language="BET"><Value>National League</Value></Text><Text Language="it"><Value>National League</Value></Text><Text Language="en"><Value>National League</Value></Text></Texts></Tournament><Tournament BetbalancerTournamentID="334"><Texts><Text Language="BET"><Value>EFL Trophy</Value></Text><Text Language="it"><Value>Football League Trophy</Value></Text><Text Language="en"><Value>EFL Trophy</Value></Text></Texts></Tournament><Tournament BetbalancerTournamentID="346"><Texts><Text Language="BET"><Value>Community Shield</Value></Text><Text Language="it"><Value>Community Shield</Value></Text><Text Language="en"><Value>Community Shield</Value></Text></Texts></Tournament><Tournament BetbalancerTournamentID="1696"><Texts><Text Language="BET"><Value>FA Cup, Qualification</Value></Text><Text Language="it"><Value>FA Cup, Qualificazioni</Value></Text><Text Language="en"><Value>FA Cup, Qualification</Value></Text></Texts></Tournament></Category></Sport></Sports></BetbalancerBetData>"""
        )
        response.sports.list.first().category.tournaments.isNotEmpty() shouldBe true
        response.sports.list.first().category.tournaments.first() shouldBe Tournament(
            17,
            Names(
                listOf(
                    Names.Name("BET", Names.Name.Value("Premier League")),
                    Names.Name("it", Names.Name.Value("Premier League")),
                    Names.Name("en", Names.Name.Value("Premier League"))
                )
            )
        )
    }

    @Test
    fun `tournaments serialization`() {
        val time = "2022-11-04T09:31:07.140Z"
        val response = TournamentsResponse(
            Timestamp(OffsetDateTime.parse(time)), TournamentsResponse.Sports(
            listOf(
                TournamentsResponse.Sports.Sport(
                    222,
                    TournamentsResponse.Category(
                        44, listOf(Tournament(4, Names(listOf(Names.Name("en", Names.Name.Value("Tournament"))))))
                    )
                )
            )
        )
        )
        val plain = xml.encodeToString(response)
        plain shouldBe """<BetbalancerBetData><Timestamp CreatedTime="2022-11-04T09:31:07.140Z" TimeZone="UTC"/><Sports><Sport BetbalancerSportID="222"><Category BetbalancerCategoryID="44"><Tournament BetbalancerTournamentID="4"><Texts><Text Language="en"><Value>Tournament</Value></Text></Texts></Tournament></Category></Sport></Sports></BetbalancerBetData>"""
    }
}
