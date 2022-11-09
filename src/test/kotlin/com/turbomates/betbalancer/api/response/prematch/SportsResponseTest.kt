@file:Suppress("SpellCheckingInspection")

package com.turbomates.betbalancer.api.response.prematch

import com.turbomates.betbalancer.api.prematch.response.SportsResponse
import com.turbomates.betbalancer.infrastructure.xml
import com.turbomates.betbalancer.model.Names
import com.turbomates.betbalancer.model.Names.Name
import com.turbomates.betbalancer.model.Sport
import com.turbomates.betbalancer.model.Timestamp
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime

class SportsResponseTest {
    @Test
    fun `sports deserialization`() {
        val response = xml.decodeFromString<SportsResponse>(
            """<?xml version="1.0" encoding="UTF-8"?><BetbalancerBetData><Timestamp CreatedTime="2022-11-03T17:05:45.148Z" TimeZone="UTC" /><Sports><Sport BetbalancerSportID="1"><Texts><Text Language="BET"><Value>Soccer</Value></Text><Text Language="it"><Value>Calcio</Value></Text><Text Language="en"><Value>Soccer</Value></Text></Texts></Sport><Sport BetbalancerSportID="2"><Texts><Text Language="BET"><Value>Basketball</Value></Text><Text Language="it"><Value>Basket</Value></Text><Text Language="en"><Value>Basketball</Value></Text></Texts></Sport><Sport BetbalancerSportID="3"><Texts><Text Language="BET"><Value>Baseball</Value></Text><Text Language="it"><Value>Baseball</Value></Text><Text Language="en"><Value>Baseball</Value></Text></Texts></Sport><Sport BetbalancerSportID="4"><Texts><Text Language="BET"><Value>Ice Hockey</Value></Text><Text Language="it"><Value>Hockey su ghiaccio</Value></Text><Text Language="en"><Value>Ice Hockey</Value></Text></Texts></Sport><Sport BetbalancerSportID="5"><Texts><Text Language="BET"><Value>Tennis</Value></Text><Text Language="it"><Value>Tennis</Value></Text><Text Language="en"><Value>Tennis</Value></Text></Texts></Sport><Sport BetbalancerSportID="6"><Texts><Text Language="BET"><Value>Handball</Value></Text><Text Language="it"><Value>Pallamano</Value></Text><Text Language="en"><Value>Handball</Value></Text></Texts></Sport><Sport BetbalancerSportID="7"><Texts><Text Language="BET"><Value>Floorball</Value></Text><Text Language="it"><Value>Floorball</Value></Text><Text Language="en"><Value>Floorball</Value></Text></Texts></Sport><Sport BetbalancerSportID="9"><Texts><Text Language="BET"><Value>Golf</Value></Text><Text Language="it"><Value>Golf</Value></Text><Text Language="en"><Value>Golf</Value></Text></Texts></Sport><Sport BetbalancerSportID="10"><Texts><Text Language="BET"><Value>Boxing</Value></Text><Text Language="it"><Value>Pugilato</Value></Text><Text Language="en"><Value>Boxing</Value></Text></Texts></Sport><Sport BetbalancerSportID="12"><Texts><Text Language="BET"><Value>Rugby</Value></Text><Text Language="it"><Value>Rugby</Value></Text><Text Language="en"><Value>Rugby</Value></Text></Texts></Sport><Sport BetbalancerSportID="13"><Texts><Text Language="BET"><Value>Aussie rules</Value></Text><Text Language="it"><Value>Football australiano</Value></Text><Text Language="en"><Value>Aussie Rules</Value></Text></Texts></Sport><Sport BetbalancerSportID="14"><Texts><Text Language="BET"><Value>Winter Sports</Value></Text><Text Language="it"><Value>Sport Invernali</Value></Text><Text Language="en"><Value>Winter Sports</Value></Text></Texts></Sport><Sport BetbalancerSportID="15"><Texts><Text Language="BET"><Value>Bandy</Value></Text><Text Language="it"><Value>Bandy</Value></Text><Text Language="en"><Value>Bandy</Value></Text></Texts></Sport><Sport BetbalancerSportID="16"><Texts><Text Language="BET"><Value>Football</Value></Text><Text Language="it"><Value>Football Americano</Value></Text><Text Language="en"><Value>American Football</Value></Text></Texts></Sport><Sport BetbalancerSportID="17"><Texts><Text Language="BET"><Value>Cycling</Value></Text><Text Language="it"><Value>Ciclismo</Value></Text><Text Language="en"><Value>Cycling</Value></Text></Texts></Sport><Sport BetbalancerSportID="18"><Texts><Text Language="BET"><Value>Specials</Value></Text><Text Language="it"><Value>Speciali</Value></Text><Text Language="en"><Value>Specials</Value></Text></Texts></Sport><Sport BetbalancerSportID="19"><Texts><Text Language="BET"><Value>Snooker</Value></Text><Text Language="it"><Value>Biliardo</Value></Text><Text Language="en"><Value>Snooker</Value></Text></Texts></Sport><Sport BetbalancerSportID="20"><Texts><Text Language="BET"><Value>Table tennis</Value></Text><Text Language="it"><Value>Tennistavolo</Value></Text><Text Language="en"><Value>Table Tennis</Value></Text></Texts></Sport><Sport BetbalancerSportID="21"><Texts><Text Language="BET"><Value>Cricket</Value></Text><Text Language="it"><Value>Cricket</Value></Text><Text Language="en"><Value>Cricket</Value></Text></Texts></Sport><Sport BetbalancerSportID="22"><Texts><Text Language="BET"><Value>Darts</Value></Text><Text Language="it"><Value>Freccette</Value></Text><Text Language="en"><Value>Darts</Value></Text></Texts></Sport><Sport BetbalancerSportID="23"><Texts><Text Language="BET"><Value>Volleyball</Value></Text><Text Language="it"><Value>Pallavolo</Value></Text><Text Language="en"><Value>Volleyball</Value></Text></Texts></Sport><Sport BetbalancerSportID="24"><Texts><Text Language="BET"><Value>Field Hockey</Value></Text><Text Language="it"><Value>Hockey su prato</Value></Text><Text Language="en"><Value>Field hockey</Value></Text></Texts></Sport><Sport BetbalancerSportID="26"><Texts><Text Language="BET"><Value>Waterpolo</Value></Text><Text Language="it"><Value>Pallanuoto</Value></Text><Text Language="en"><Value>Waterpolo</Value></Text></Texts></Sport><Sport BetbalancerSportID="28"><Texts><Text Language="BET"><Value>Curling</Value></Text><Text Language="it"><Value>Curling</Value></Text><Text Language="en"><Value>Curling</Value></Text></Texts></Sport><Sport BetbalancerSportID="29"><Texts><Text Language="BET"><Value>Futsal</Value></Text><Text Language="it"><Value>Calcio a 5</Value></Text><Text Language="en"><Value>Futsal</Value></Text></Texts></Sport><Sport BetbalancerSportID="30"><Texts><Text Language="BET"><Value>Olympics</Value></Text><Text Language="it"><Value>Olimpiadi</Value></Text><Text Language="en"><Value>Olympics</Value></Text></Texts></Sport><Sport BetbalancerSportID="31"><Texts><Text Language="BET"><Value>Badminton</Value></Text><Text Language="it"><Value>Badminton</Value></Text><Text Language="en"><Value>Badminton</Value></Text></Texts></Sport><Sport BetbalancerSportID="32"><Texts><Text Language="BET"><Value>Bowls</Value></Text><Text Language="it"><Value>Bowls</Value></Text><Text Language="en"><Value>Bowls</Value></Text></Texts></Sport><Sport BetbalancerSportID="34"><Texts><Text Language="BET"><Value>Beach Volley</Value></Text><Text Language="it"><Value>Beach Volley</Value></Text><Text Language="en"><Value>Beach Volley</Value></Text></Texts></Sport><Sport BetbalancerSportID="36"><Texts><Text Language="BET"><Value>Athletics</Value></Text><Text Language="it"><Value>Atletica</Value></Text><Text Language="en"><Value>Athletics</Value></Text></Texts></Sport><Sport BetbalancerSportID="37"><Texts><Text Language="BET"><Value>Squash</Value></Text><Text Language="it"><Value>Squash</Value></Text><Text Language="en"><Value>Squash</Value></Text></Texts></Sport><Sport BetbalancerSportID="39"><Texts><Text Language="BET"><Value>Lacrosse</Value></Text><Text Language="it"><Value>Lacrosse</Value></Text><Text Language="en"><Value>Lacrosse</Value></Text></Texts></Sport><Sport BetbalancerSportID="40"><Texts><Text Language="BET"><Value>Formula 1</Value></Text><Text Language="it"><Value>Formula 1</Value></Text><Text Language="en"><Value>Formula 1</Value></Text></Texts></Sport><Sport BetbalancerSportID="43"><Texts><Text Language="BET"><Value>Alpine Skiing</Value></Text><Text Language="it"><Value>Sci Alpino</Value></Text><Text Language="en"><Value>Alpine Skiing</Value></Text></Texts></Sport><Sport BetbalancerSportID="44"><Texts><Text Language="BET"><Value>Biathlon</Value></Text><Text Language="it"><Value>Biathlon</Value></Text><Text Language="en"><Value>Biathlon</Value></Text></Texts></Sport><Sport BetbalancerSportID="46"><Texts><Text Language="BET"><Value>Cross-Country</Value></Text><Text Language="it"><Value>Sci di fondo</Value></Text><Text Language="en"><Value>Cross-Country</Value></Text></Texts></Sport><Sport BetbalancerSportID="48"><Texts><Text Language="BET"><Value>Ski Jumping</Value></Text><Text Language="it"><Value>Salto con gli Sci</Value></Text><Text Language="en"><Value>Ski Jumping</Value></Text></Texts></Sport><Sport BetbalancerSportID="52"><Texts><Text Language="BET"><Value>Swimming</Value></Text><Text Language="it"><Value>Nuoto</Value></Text><Text Language="en"><Value>Swimming</Value></Text></Texts></Sport><Sport BetbalancerSportID="56"><Texts><Text Language="BET"><Value>Schwingen</Value></Text><Text Language="it"><Value>Lotta Svizzera</Value></Text><Text Language="en"><Value>Schwingen</Value></Text></Texts></Sport><Sport BetbalancerSportID="60"><Texts><Text Language="BET"><Value>Beach Soccer</Value></Text><Text Language="it"><Value>Beach Soccer</Value></Text><Text Language="en"><Value>Beach Soccer</Value></Text></Texts></Sport><Sport BetbalancerSportID="61"><Texts><Text Language="BET"><Value>Pesapallo</Value></Text><Text Language="it"><Value>Pesapallo</Value></Text><Text Language="en"><Value>Pesapallo</Value></Text></Texts></Sport><Sport BetbalancerSportID="64"><Texts><Text Language="BET"><Value>Rowing</Value></Text><Text Language="it"><Value>Canottaggio</Value></Text><Text Language="en"><Value>Rowing</Value></Text></Texts></Sport><Sport BetbalancerSportID="72"><Texts><Text Language="BET"><Value>Canoeing</Value></Text><Text Language="it"><Value>Canoa</Value></Text><Text Language="en"><Value>Canoeing</Value></Text></Texts></Sport><Sport BetbalancerSportID="75"><Texts><Text Language="BET"><Value>Archery</Value></Text><Text Language="it"><Value>Tiro con l'arco</Value></Text><Text Language="en"><Value>Archery</Value></Text></Texts></Sport><Sport BetbalancerSportID="76"><Texts><Text Language="BET"><Value>Equestrian</Value></Text><Text Language="it"><Value>Sport equestri</Value></Text><Text Language="en"><Value>Equestrian</Value></Text></Texts></Sport><Sport BetbalancerSportID="77"><Texts><Text Language="BET"><Value>Fencing</Value></Text><Text Language="it"><Value>Scherma</Value></Text><Text Language="en"><Value>Fencing</Value></Text></Texts></Sport><Sport BetbalancerSportID="78"><Texts><Text Language="BET"><Value>Gymnastics</Value></Text><Text Language="it"><Value>Ginnastica</Value></Text><Text Language="en"><Value>Gymnastics</Value></Text></Texts></Sport><Sport BetbalancerSportID="79"><Texts><Text Language="BET"><Value>Judo</Value></Text><Text Language="it"><Value>Judo</Value></Text><Text Language="en"><Value>Judo</Value></Text></Texts></Sport><Sport BetbalancerSportID="80"><Texts><Text Language="BET"><Value>Modern Pentathlon</Value></Text><Text Language="it"><Value>Pentathlon Moderno</Value></Text><Text Language="en"><Value>Modern Pentathlon</Value></Text></Texts></Sport><Sport BetbalancerSportID="81"><Texts><Text Language="BET"><Value>Sailing</Value></Text><Text Language="it"><Value>Vela</Value></Text><Text Language="en"><Value>Sailing</Value></Text></Texts></Sport><Sport BetbalancerSportID="83"><Texts><Text Language="BET"><Value>Taekwondo</Value></Text><Text Language="it"><Value>Taekwondo</Value></Text><Text Language="en"><Value>Taekwondo</Value></Text></Texts></Sport><Sport BetbalancerSportID="84"><Texts><Text Language="BET"><Value>Triathlon</Value></Text><Text Language="it"><Value>Triathlon</Value></Text><Text Language="en"><Value>Triathlon</Value></Text></Texts></Sport><Sport BetbalancerSportID="85"><Texts><Text Language="BET"><Value>Weightlifting</Value></Text><Text Language="it"><Value>Sollevamento pesi</Value></Text><Text Language="en"><Value>Weightlifting</Value></Text></Texts></Sport><Sport BetbalancerSportID="86"><Texts><Text Language="BET"><Value>Wrestling</Value></Text><Text Language="it"><Value>Wrestling</Value></Text><Text Language="en"><Value>Wrestling</Value></Text></Texts></Sport><Sport BetbalancerSportID="88"><Texts><Text Language="BET"><Value>Mountain Bike</Value></Text><Text Language="it"><Value>Mountain Bike</Value></Text><Text Language="en"><Value>Mountain Bike</Value></Text></Texts></Sport><Sport BetbalancerSportID="96"><Texts><Text Language="BET"><Value>Diving</Value></Text><Text Language="it"><Value>Tuffi</Value></Text><Text Language="en"><Value>Diving</Value></Text></Texts></Sport><Sport BetbalancerSportID="97"><Texts><Text Language="BET"><Value>Track cycling</Value></Text><Text Language="it"><Value>Ciclismo su pista</Value></Text><Text Language="en"><Value>Track cycling</Value></Text></Texts></Sport><Sport BetbalancerSportID="101"><Texts><Text Language="BET"><Value>Rally</Value></Text><Text Language="it"><Value>Rally</Value></Text><Text Language="en"><Value>Rally</Value></Text></Texts></Sport><Sport BetbalancerSportID="103"><Texts><Text Language="BET"><Value>Freestyle Skiing</Value></Text><Text Language="it"><Value>Pattinaggio Freestyle</Value></Text><Text Language="en"><Value>Freestyle Skiing</Value></Text></Texts></Sport><Sport BetbalancerSportID="110"><Texts><Text Language="BET"><Value>ESport League of Legends</Value></Text><Text Language="it"><Value>League of Legends</Value></Text><Text Language="en"><Value>League of Legends</Value></Text></Texts></Sport><Sport BetbalancerSportID="117"><Texts><Text Language="BET"><Value>MMA</Value></Text><Text Language="it"><Value>MMA</Value></Text><Text Language="en"><Value>MMA</Value></Text></Texts></Sport><Sport BetbalancerSportID="129"><Texts><Text Language="BET"><Value>Indy Racing</Value></Text><Text Language="it"><Value>Indy</Value></Text><Text Language="en"><Value>Indy Racing</Value></Text></Texts></Sport><Sport BetbalancerSportID="131"><Texts><Text Language="BET"><Value>Speedway</Value></Text><Text Language="it"><Value>Speedway</Value></Text><Text Language="en"><Value>Speedway</Value></Text></Texts></Sport><Sport BetbalancerSportID="136"><Texts><Text Language="BET"><Value>Gaelic Hurling</Value></Text><Text Language="it"><Value>Hurling</Value></Text><Text Language="en"><Value>Gaelic Hurling</Value></Text></Texts></Sport><Sport BetbalancerSportID="138"><Texts><Text Language="BET"><Value>Kabaddi</Value></Text><Text Language="it"><Value>Kabaddi</Value></Text><Text Language="en"><Value>Kabaddi</Value></Text></Texts></Sport><Sport BetbalancerSportID="142"><Texts><Text Language="BET"><Value>Formula E</Value></Text><Text Language="it"><Value>Formula E</Value></Text><Text Language="en"><Value>Formula E</Value></Text></Texts></Sport><Sport BetbalancerSportID="155"><Texts><Text Language="BET"><Value>Basketball 3x3</Value></Text><Text Language="it"><Value>Basketball 3x3</Value></Text><Text Language="en"><Value>Basketball 3x3</Value></Text></Texts></Sport><Sport BetbalancerSportID="182"><Texts><Text Language="BET"><Value>Marathon Swimming</Value></Text><Text Language="it"><Value>Maratona nuoto</Value></Text><Text Language="en"><Value>Marathon Swimming</Value></Text></Texts></Sport><Sport BetbalancerSportID="188"><Texts><Text Language="BET"><Value>Touring Car Racing</Value></Text><Text Language="it"><Value>Touring Car</Value></Text><Text Language="en"><Value>Touring Car Racing</Value></Text></Texts></Sport><Sport BetbalancerSportID="190"><Texts><Text Language="BET"><Value>Motorcycle Racing</Value></Text><Text Language="it"><Value>Motociclismo</Value></Text><Text Language="en"><Value>Motorcycle Racing</Value></Text></Texts></Sport><Sport BetbalancerSportID="191"><Texts><Text Language="BET"><Value>Stock Car Racing</Value></Text><Text Language="it"><Value>Stock Car</Value></Text><Text Language="en"><Value>Stock Car Racing</Value></Text></Texts></Sport></Sports></BetbalancerBetData>"""
        )
        response.sports.list.isNotEmpty() shouldBe true
        response.sports.list.first() shouldBe Sport(
            1,
            Names(
                listOf(
                    Name("BET", Name.Value("Soccer")),
                    Name("it", Name.Value("Calcio")),
                    Name("en", Name.Value("Soccer"))
                )
            )
        )
    }

    @Test
    fun `sports serialization`() {
        val time = "2022-11-04T09:31:07.140Z"
        val response = SportsResponse(Timestamp(OffsetDateTime.parse(time)), SportsResponse.Sports(listOf(
            Sport(222, Names(listOf(
                Name("en", Name.Value("Soccer"))
            )))
        )))
        val plain = xml.encodeToString(response)
        plain shouldBe """<BetbalancerBetData><Timestamp CreatedTime="$time" TimeZone="UTC"/><Sports><Sport BetbalancerSportID="222"><Texts><Text Language="en"><Value>Soccer</Value></Text></Texts></Sport></Sports></BetbalancerBetData>"""
    }
}
