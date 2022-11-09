@file:Suppress("SpellCheckingInspection")

package com.turbomates.betbalancer.api.response.prematch

import com.turbomates.betbalancer.infrastructure.xml
import com.turbomates.betbalancer.model.Names
import com.turbomates.betbalancer.model.Outright
import com.turbomates.betbalancer.model.Timestamp
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime

class OutrightsResponseTest {
    @Test
    fun `outrights deserialization`() {
        val response = xml.decodeFromString<OutrightsResponse>(
            """<?xml version="1.0" encoding="UTF-8"?><BetbalancerBetData><Timestamp CreatedTime="2022-11-08T11:20:36.987Z" TimeZone="UTC" /><Outrights><Outright outrightId="95691"><Texts><Text Language="BET"><Value>Premiership - To Finish Bottom</Value></Text><Text Language="it"><Value>Scottish Premiership - Chi Finirá Ultimo</Value></Text><Text Language="en"><Value>Premiership - To Finish Bottom</Value></Text></Texts></Outright></Outrights></BetbalancerBetData>"""
        )
        response.outrights.list.isNotEmpty() shouldBe true
        response.outrights.list.first() shouldBe Outright(
            95691,
            Names(
                listOf(
                    Names.Name("BET", Names.Name.Value("Premiership - To Finish Bottom")),
                    Names.Name("it", Names.Name.Value("Scottish Premiership - Chi Finirá Ultimo")),
                    Names.Name("en", Names.Name.Value("Premiership - To Finish Bottom"))
                )
            )
        )
    }

    @Test
    fun `outrights serialization`() {
        val time = "2022-11-04T09:31:07.140Z"
        val response = OutrightsResponse(
            Timestamp(OffsetDateTime.parse(time)), OutrightsResponse.Outrights(
            listOf(
                Outright(
                    222,
                    Names(listOf(Names.Name("en", Names.Name.Value("Premiership - To Finish Bottom")), Names.Name("it", Names.Name.Value("Scottish Premiership - Chi Finirá Ultimo"))))
                )
            )
        )
        )
        val plain = xml.encodeToString(response)
        plain shouldBe """<BetbalancerBetData><Timestamp CreatedTime="2022-11-04T09:31:07.140Z" TimeZone="UTC"/><Outrights><Outright outrightId="222"><Texts><Text Language="en"><Value>Premiership - To Finish Bottom</Value></Text><Text Language="it"><Value>Scottish Premiership - Chi Finirá Ultimo</Value></Text></Texts></Outright></Outrights></BetbalancerBetData>"""
    }
}
