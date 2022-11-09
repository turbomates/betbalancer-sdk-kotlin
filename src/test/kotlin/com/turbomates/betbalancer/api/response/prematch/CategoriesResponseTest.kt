package com.turbomates.betbalancer.api.response.prematch

import com.turbomates.betbalancer.infrastructure.xml
import com.turbomates.betbalancer.model.Category
import com.turbomates.betbalancer.model.Names
import com.turbomates.betbalancer.model.Names.Name
import com.turbomates.betbalancer.model.Timestamp
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime

class CategoriesResponseTest {
    @Test
    fun `sports deserialization`() {
        val response = xml.decodeFromString<CategoriesResponse>(
            """<?xml version="1.0" encoding="UTF-8"?><BetbalancerBetData><Timestamp CreatedTime="2022-11-04T11:28:28.062Z" TimeZone="UTC" /><Sports><Sport BetbalancerSportID="1"><Category BetbalancerCategoryID="5"><Texts><Text Language="BET"><Value>Norway</Value></Text><Text Language="it"><Value>Norvegia</Value></Text><Text Language="en"><Value>Norway</Value></Text></Texts></Category></Sport></Sports></BetbalancerBetData>"""
        )
        response.sports.list.first().category.translatedNames.list.isNotEmpty() shouldBe true
        response.sports.list.first().category shouldBe Category(
            5,
            Names(
                listOf(
                    Name("BET", Name.Value("Norway")),
                    Name("it", Name.Value("Norvegia")),
                    Name("en", Name.Value("Norway"))
                )
            )
        )
    }

    @Test
    fun `login serialization`() {
        val time = "2022-11-04T09:31:07.140Z"
        val response = CategoriesResponse(Timestamp(OffsetDateTime.parse(time)), CategoriesResponse.Sports(listOf(
            CategoriesResponse.Sports.Sport(
                222,
                Category(44, Names(listOf(Name("en", Name.Value("Soccer")))))
            )
        )))
        val plain = xml.encodeToString(response)
        plain shouldBe """<BetbalancerBetData><Timestamp CreatedTime="$time" TimeZone="UTC"/><Sports><Sport BetbalancerSportID="222"><Category BetbalancerCategoryID="44"><Texts><Text Language="en"><Value>Soccer</Value></Text></Texts></Category></Sport></Sports></BetbalancerBetData>"""
    }
}
