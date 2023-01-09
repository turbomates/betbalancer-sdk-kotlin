@file:Suppress("SpellCheckingInspection")

package com.turbomates.betbalancer.api.prematch.response

import com.turbomates.betbalancer.api.prematch.response.MatchesResponse.CompetitorNames.CompetitorName
import com.turbomates.betbalancer.api.prematch.response.MatchesResponse.CompetitorNames.Name
import com.turbomates.betbalancer.api.prematch.response.MatchesResponse.Match.BetResults
import com.turbomates.betbalancer.api.prematch.response.MatchesResponse.Match.Fixture
import com.turbomates.betbalancer.api.prematch.response.MatchesResponse.Match.Result
import com.turbomates.betbalancer.api.prematch.response.MatchesResponse.Match.Result.ScoreInfo
import com.turbomates.betbalancer.infrastructure.xml
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import org.junit.jupiter.api.Test

class MatchesResponseTest {
    @Test
    fun `matches deserialization`() {
        val response = xml.decodeFromString<MatchesResponse>(
            """<?xml version="1.0" encoding="UTF-8"?><BetbalancerBetData><Timestamp CreatedTime="2023-01-05T14:32:24.568Z" TimeZone="UTC" /><Sports><Sport BetbalancerSportID="22"><Texts><Text Language="BET"><Value>Darts</Value></Text><Text Language="it"><Value>Freccette</Value></Text></Texts><Category BetbalancerCategoryID="104"><Texts><Text Language="BET"><Value>International</Value></Text><Text Language="it"><Value>Internazionale</Value></Text></Texts><Tournament BetbalancerTournamentID="616"><Texts><Text Language="BET"><Value>PDC World Championship</Value></Text><Text Language="it"><Value>PDC Campionato del Mondo</Value></Text></Texts><SuperTournament Name="PDC World Championship" SuperID="616"/><Match BetbalancerMatchID="37789559"><Fixture><Competitors><Texts><Text ID="260885"  SUPERID="260885" Type="1"><Text Language="BET"><Value>Noppert, Danny</Value></Text><Text Language="it"><Value>Noppert, Danny</Value></Text></Text></Texts><Texts><Text ID="239042"  SUPERID="239042" Type="1"><Text Language="BET"><Value>Soutar, Alan</Value></Text><Text Language="it"><Value>SOUTAR, ALAN</Value></Text></Text></Texts></Competitors><DateInfo><MatchDate Changed="1">2022-12-28T14:15:00.000Z</MatchDate></DateInfo><StatusInfo><Off>0</Off></StatusInfo><NeutralGround>0</NeutralGround><NumberOfSets>7</NumberOfSets></Fixture><Result><ScoreInfo><Score Type="FT">2:4</Score></ScoreInfo></Result><BetResult><W OddsType="186" OutComeId="5" OutCome="{${"$"}competitor2}"/><W OddsType="188" OutComeId="1715" OutCome="{${"$"}competitor2} ({-hcp})" SpecialBetValue="-1.5"/><W OddsType="202" OutComeId="4" OutCome="{${"$"}competitor1}" variant="setnr=1"/><W OddsType="314" OutComeId="12" OutCome="over {total}" SpecialBetValue="5.5"/><W OddsType="371" OutComeId="1714" OutCome="{${"$"}competitor1} ({+hcp})" SpecialBetValue="-1.5" variant="setnr=1"/><W OddsType="372" OutComeId="13" OutCome="under {total}" SpecialBetValue="4.5" variant="setnr=1"/><W OddsType="374" OutComeId="9" OutCome="3:1" variant="setnr=1|variant=sr:correct_score:bestof:5"/><W OddsType="375" OutComeId="4" OutCome="{${"$"}competitor1}" variant="setnr=1|legnr=1"/><W OddsType="381" OutComeId="1041" OutCome="{${"$"}competitor1}"/><W OddsType="382" OutComeId="6" OutCome="{${"$"}competitor1}" variant="xth=1"/><W OddsType="383" OutComeId="1715" OutCome="{${"$"}competitor2} ({-hcp})" SpecialBetValue="-1.5"/><W OddsType="384" OutComeId="13" OutCome="under {total}" SpecialBetValue="12.5"/><W OddsType="385" OutComeId="13" OutCome="under {total}" SpecialBetValue="7.5"/><W OddsType="386" OutComeId="13" OutCome="under {total}" SpecialBetValue="5.5"/><W OddsType="532" OutComeId="19" OutCome="2:4" variant="variant=sr:correct_score:bestof:7"/></BetResult></Match><Match BetbalancerMatchID="37789565"><Fixture><Competitors><Texts><Text ID="35936"  SUPERID="35936" Type="1"><Text Language="BET"><Value>Smith, Michael</Value></Text><Text Language="it"><Value>Smith, Michael</Value></Text></Text></Texts><Texts><Text ID="163422"  SUPERID="163422" Type="1"><Text Language="BET"><Value>Schindler, Martin</Value></Text><Text Language="it"><Value>Schindler, Martin</Value></Text></Text></Texts></Competitors><DateInfo><MatchDate Changed="1">2022-12-28T21:50:00.000Z</MatchDate></DateInfo><StatusInfo><Off>0</Off></StatusInfo><NeutralGround>0</NeutralGround><NumberOfSets>7</NumberOfSets></Fixture><Result><ScoreInfo><Score Type="FT">4:3</Score></ScoreInfo></Result><BetResult><W OddsType="186" OutComeId="4" OutCome="{${"$"}competitor1}"/><W OddsType="188" OutComeId="1715" OutCome="{${"$"}competitor2} ({-hcp})" SpecialBetValue="-2.5"/><W OddsType="202" OutComeId="5" OutCome="{${"$"}competitor2}" variant="setnr=1"/><W OddsType="314" OutComeId="12" OutCome="over {total}" SpecialBetValue="5.5"/><W OddsType="371" OutComeId="1715" OutCome="{${"$"}competitor2} ({-hcp})" SpecialBetValue="-1.5" variant="setnr=1"/><W OddsType="372" OutComeId="12" OutCome="over {total}" SpecialBetValue="3.5" variant="setnr=1"/><W OddsType="374" OutComeId="11" OutCome="2:3" variant="setnr=1|variant=sr:correct_score:bestof:5"/><W OddsType="375" OutComeId="4" OutCome="{${"$"}competitor1}" variant="setnr=1|legnr=1"/><W OddsType="381" OutComeId="1042" OutCome="{${"$"}competitor2}"/><W OddsType="382" OutComeId="8" OutCome="{${"$"}competitor2}" variant="xth=1"/><W OddsType="383" OutComeId="1715" OutCome="{${"$"}competitor2} ({-hcp})" SpecialBetValue="-1.5"/><W OddsType="384" OutComeId="12" OutCome="over {total}" SpecialBetValue="15.5"/><W OddsType="385" OutComeId="13" OutCome="under {total}" SpecialBetValue="8.5"/><W OddsType="386" OutComeId="12" OutCome="over {total}" SpecialBetValue="7.5"/><W OddsType="532" OutComeId="17" OutCome="4:3" variant="variant=sr:correct_score:bestof:7"/></BetResult></Match></Tournament></Category></Sport></Sports></BetbalancerBetData>"""
        )
        response.sports.list.isNotEmpty() shouldBe true
        response.sports.list.first().category.tournament.matches.first() shouldBe MatchesResponse.Match(
            37789559,
            Fixture(
                Fixture.Competitors(
                    listOf(
                        MatchesResponse.CompetitorNames(
                            listOf(
                                CompetitorName(
                                    260885,
                                    260885,
                                    1,
                                    listOf(Name("BET", Name.Value("Noppert, Danny")), Name("it", Name.Value("Noppert, Danny")))
                                ),
                            )
                        ),
                        MatchesResponse.CompetitorNames(
                            listOf(
                                CompetitorName(
                                    239042,
                                    239042,
                                    1,
                                    listOf(Name("BET", Name.Value("Soutar, Alan")), Name("it", Name.Value("SOUTAR, ALAN")))
                                ),
                            )
                        )
                    )
                ),
                Fixture.DateInfo(
                    Fixture.DateInfo.MatchDate(1, "2022-12-28T14:15:00.000Z")
                ),
                Fixture.StatusInfo(
                    Fixture.StatusInfo.Off(0)
                ),
                Fixture.NeutralGround(0),
                Fixture.NumberOfSets(7)
            ),
            Result(ScoreInfo(ScoreInfo.Score("FT", "2:4"))),
            BetResults(listOf(
                BetResults.Result(186, 5, """{${"$"}competitor2}"""),
                BetResults.Result(188, 1715, """{${"$"}competitor2} ({-hcp})""", specialBetValue = "-1.5"),
                BetResults.Result(202, 4, """{${"$"}competitor1}""", variant = "setnr=1"),
                BetResults.Result(314, 12, """over {total}""", specialBetValue = "5.5"),
                BetResults.Result(371, 1714, """{${"$"}competitor1} ({+hcp})""", specialBetValue = "-1.5", variant = "setnr=1"),
                BetResults.Result(372, 13, """under {total}""", variant = "setnr=1", specialBetValue = "4.5"),
                BetResults.Result(374, 9, """3:1""", variant = "setnr=1|variant=sr:correct_score:bestof:5"),
                BetResults.Result(375, 4, """{${"$"}competitor1}""", variant = "setnr=1|legnr=1"),
                BetResults.Result(381, 1041, """{${"$"}competitor1}"""),
                BetResults.Result(382, 6, """{${"$"}competitor1}""", variant = "xth=1"),
                BetResults.Result(383, 1715, """{${"$"}competitor2} ({-hcp})""", specialBetValue = "-1.5"),
                BetResults.Result(384, 13, """under {total}""", specialBetValue = "12.5"),
                BetResults.Result(385, 13, """under {total}""", specialBetValue = "7.5"),
                BetResults.Result(386, 13, """under {total}""", specialBetValue = "5.5"),
                BetResults.Result(532, 19, """2:4""", variant = "variant=sr:correct_score:bestof:7"),
            ))
        )
    }
}
