package com.turbomates.betbalancer.api.prematch.response

import com.turbomates.betbalancer.model.Names
import com.turbomates.betbalancer.model.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlValue

@Serializable
@SerialName("BetbalancerBetData")
data class MatchesResponse(
    @SerialName("Timestamp")
    val timestamp: Timestamp,
    val sports: Sports
) {
    @Serializable
    data class Sports(val list: List<Sport>) {
        @Serializable
        data class Sport(
            @SerialName("BetbalancerSportID")
            val id: Int,
            val translatedNames: Names,
            val category: Category
        )
    }

    @Serializable
    @SerialName("Category")
    data class Category(
        @SerialName("BetbalancerCategoryID")
        val id: Int,
        val translatedNames: Names,
        val tournament: Tournament
    )

    @Serializable
    @SerialName("Tournament")
    data class Tournament(
        @SerialName("BetbalancerTournamentID")
        val id: Int,
        val translatedNames: Names,
        val superTournament: SuperTournament,
        val matches: List<Match>
    ) {
        @Serializable
        data class SuperTournament(
            @SerialName("Name")
            val name: String,
            @SerialName("SuperID")
            val superId: Int,
        )
    }

    @Serializable
    @SerialName("Match")
    data class Match(
        @SerialName("BetbalancerMatchID")
        val id: Int,
        val fixture: Fixture,
        val result: Result,
        val betResult: BetResults
    ) {
        @Serializable
        data class Fixture(
            @SerialName("Competitors")
            val competitors: Competitors,
            val dateInfo: DateInfo,
            val statusInfo: StatusInfo,
            val neutralGround: NeutralGround,
            val numberOfSets: NumberOfSets
        ) {
            @Serializable
            data class Competitors(val list: List<CompetitorNames>)

            @Serializable
            data class DateInfo(val matchDate: MatchDate) {
                @Serializable
                data class MatchDate(
                    @SerialName("Changed")
                    val changed: Int,
                    @XmlValue(true) val value: String
                )
            }

            @Serializable
            data class StatusInfo(val off: Off) {
                @Serializable
                data class Off(@XmlValue(true) val value: Int)
            }

            @Serializable
            data class NeutralGround(@XmlValue(true) val value: Int)

            @Serializable
            data class NumberOfSets(@XmlValue(true) val value: Int)
        }

        @Serializable
        data class Result(val scoreInfo: ScoreInfo) {
            @Serializable
            data class ScoreInfo(val score: Score) {
                @Serializable()
                data class Score(
                    @SerialName("Type")
                    val type: String,
                    @XmlValue(true) val value: String
                )
            }
        }

        @Serializable
        @SerialName("BetResult")
        data class BetResults(val list: List<Result>) {
            @Serializable
            @SerialName("W")
            data class Result(
                @SerialName("OddsType")
                val oddsType: Int,
                @SerialName("OutComeId")
                val outComeId: Int,
                @SerialName("OutCome")
                val outCome: String,
                val variant: String? = null,
                @SerialName("SpecialBetValue")
                val specialBetValue: String? = null
            )
        }
    }

    @Serializable
    @SerialName("Texts")
    data class CompetitorNames(val list: List<CompetitorName>) {
        @Serializable
        @SerialName("Text")
        data class CompetitorName(
            @SerialName("ID")
            val id: Int,
            @SerialName("SUPERID")
            val superId: Int,
            @SerialName("Type")
            val type: Int,
            val list: List<Name>
        )

        @Serializable
        @SerialName("Text")
        data class Name(
            @SerialName("Language")
            val language: String,
            private val name: Value
        ) {
            override fun toString(): String {
                return name.value
            }

            @Serializable
            data class Value(@XmlValue(true) val value: String)
        }
    }
}
